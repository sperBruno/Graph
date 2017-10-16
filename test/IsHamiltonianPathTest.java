import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class IsHamiltonianPathTest
{
  public static final String FILENAME = "is_hamiltonian_path_test.txt";
  
  public IsHamiltonianPathTest() {}
  
  protected List<String> createValidPath()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("1");
    localLinkedList.add("2");
    localLinkedList.add("3");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("0");
    return localLinkedList;
  }
  
  @Before
  public void setUp() throws Exception
  {}
  
  @Test
  public void testNullGraph() {
    List localList = createValidPath();
    try {
      boolean bool = GraphUtils.isHamiltonianPath(null, localList);
      Assert.assertFalse("isHamiltonianPath should return false when input Graph is null", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when input Graph is null");
    }
  }
  
  @Test
  public void testNullLinkedList() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, null);
      Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is null", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when input LinkedList is null");
    }
  }
  
  @Test
  public void testEmptyLinkedList() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, new LinkedList());
      Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is empty", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when input LinkedList is empty");
    }
  }
  
  @Test
  public void testValidUndirected() {
    List localList = createValidPath();
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, localList);
      Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid Hamiltonian path in undirected graph");
    }
  }
  
  @Test
  public void testValidDirected() {
    List localList = createValidPath();
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localList);
      Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in directed graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid Hamiltonian path in directed graph");
    }
  }
  
  @Test
  public void testValidDoesntVisitAllNodesUndirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("2");
    localLinkedList.add("5");
    localLinkedList.add("0");
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that does not visit all nodes in undirected graph");
    }
  }
  
  @Test
  public void testValidDoesntVisitAllNodesDirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("2");
    localLinkedList.add("5");
    localLinkedList.add("0");
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in directed graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that does not visit all nodes in directed graph");
    }
  }
  
  @Test
  public void testNotCycleUndirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("1");
    localLinkedList.add("2");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("3");
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that is not a cycle in undirected graph");
    }
  }
  
  @Test
  public void testNotCycleDirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("1");
    localLinkedList.add("2");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("3");
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in directed graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that is not a cycle in directed graph");
    }
  }
  
  @Test
  public void testVisitsNodeMoreThanOnceUndirected()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("5");
    localLinkedList.add("3");
    localLinkedList.add("1");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("0");
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that visits a node more than once in undirected graph");
    }
  }
  
  @Test
  public void testVisitsNodeMoreThanOnceDirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("5");
    localLinkedList.add("3");
    localLinkedList.add("1");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("0");
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in directed graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a valid path that visits a node more than once in directed graph");
    }
  }
  
  @Test
  public void testUnconnectedNodesUndirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("1");
    localLinkedList.add("3");
    localLinkedList.add("2");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("0");
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("is_hamiltonian_path_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localUndirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath " + localException + " when list represents a path in which some nodes are not connected in undirected graph");
    }
  }
  
  @Test
  public void testUnconnectedNodesDirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("0");
    localLinkedList.add("1");
    localLinkedList.add("3");
    localLinkedList.add("2");
    localLinkedList.add("4");
    localLinkedList.add("5");
    localLinkedList.add("0");
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in directed graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a path in which some nodes are not connected in directed graph");
    }
  }
  
  @Test
  public void testNotConnectedDirectedButConnectedUndirected() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("5");
    localLinkedList.add("4");
    localLinkedList.add("3");
    localLinkedList.add("2");
    localLinkedList.add("1");
    localLinkedList.add("0");
    localLinkedList.add("5");
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("is_hamiltonian_path_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }
    try {
      boolean bool = GraphUtils.isHamiltonianPath(localDirectedGraph, localLinkedList);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph", bool);
    }
    catch (Exception localException) {
      Assert.fail("isHamiltonianPath throws " + localException + " when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph");
    }
  }
}
