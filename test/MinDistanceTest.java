import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinDistanceTest
{
  public static final String FILENAME = "graph_builder_test.txt";
  
  public MinDistanceTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {}
  
  @Test
  public void testNullGraph()
  {
    try
    {
      int i = GraphUtils.minDistance(null, "src", "dest");
      Assert.assertTrue("minDistance should return -1 when input Graph is null", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when input Graph is null");
    }
  }
  
  @Test
  public void testNullSrc() {
    UndirectedGraph localUndirectedGraph = new UndirectedGraph();
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, null, "dest");
      Assert.assertTrue("minDistance should return -1 when input src is null", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when input src is null");
    }
  }
  
  @Test
  public void testNullDest() {
    UndirectedGraph localUndirectedGraph = new UndirectedGraph();
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "src", null);
      Assert.assertTrue("minDistance should return -1 when input dest is null", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when input dest is null");
    }
  }
  
  @Test
  public void testSrcNotInGraph() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "BAD", "3");
      Assert.assertTrue("minDistance should return -1 when input src is not in graph", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when input src is not in graph");
    }
  }
  
  @Test
  public void testDestNotInGraph() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "2", "BAD");
      Assert.assertTrue("minDistance should return -1 when input dest is not in graph", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when input dest is not in graph");
    }
  }
  
  @Test
  public void testSrcDestSame() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "0", "0");
      Assert.assertTrue("minDistance should return 0 when src and dest are the same", i == 0);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are the same");
    }
  }
  
  @Test
  public void testSrcDestConnectedUndirected() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "1", "2");
      Assert.assertTrue("minDistance should return 1 when src and dest are connected by a single edge in an undirected graph", i == 1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are connected by a single edge in an undirected graph");
    }
  }
  
  @Test
  public void testSrcDestConnectedDirected() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localDirectedGraph, "1", "2");
      Assert.assertTrue("minDistance should return 1 when src and dest are connected by a single edge in a directed graph", i == 1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are connected by a single edge in a directed graph");
    }
  }
  
  @Test
  public void testSrcDestMultipleEdgesUndirected() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "0", "6");
      Assert.assertTrue("minDistance returns incorrect output when src and dest are connected via multiple edges in an undirected graph", i == 3);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are connected via multiple edges in an undirected graph");
    }
  }
  
  @Test
  public void testSrcDestMultipleEdgesDirected() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localDirectedGraph, "0", "6");
      Assert.assertTrue("minDistance returns incorrect output when src and dest are connected via multiple edges in a directed graph", i == 3);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are connected via multiple edges in a directed graph");
    }
  }
  
  @Test
  public void testSrcDestNotConnectedUndirected() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localUndirectedGraph, "0", "8");
      Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in an undirected graph", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are not connected in an undirected graph");
    }
  }
  
  @Test
  public void testSrcDestNotConnectedDirected() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localDirectedGraph, "0", "8");
      Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in a directed graph", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are not connected in a directed graph");
    }
  }
  
  @Test
  public void testSrcDestNotConnectedDirectedButConnectedUndirected() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      int i = GraphUtils.minDistance(localDirectedGraph, "1", "3");
      Assert.assertTrue("minDistance returns incorrect output when src and dest are not connected in a directed graph but are connected in underlying undirected graph", i == -1);
    }
    catch (Exception localException) {
      Assert.fail("minDistance throws " + localException + " when src and dest are not connected in a directed graph but are connected in underlying undirected graph");
    }
  }
}
