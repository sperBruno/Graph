import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class NodesWithinDistanceTest
{
  public static final String FILENAME = "graph_builder_test.txt";
  
  public NodesWithinDistanceTest() {}
  
  @org.junit.Before
  public void setUp() throws Exception
  {}
  
  @Test
  public void testNullGraph()
  {
    try
    {
      Set localSet = GraphUtils.nodesWithinDistance(null, "0", 3);
      Assert.assertNull("nodesWithinDistance should return null when input Graph is null", localSet);
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when input Graph is null");
    }
  }
  
  @Test
  public void testNullSrc() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, null, 3);
      Assert.assertNull("nodesWithinDistance should return null when input src is null", localSet);
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when input src is null");
    }
  }
  
  @Test
  public void testSrcNotInGraph() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "banana", 3);
      Assert.assertNull("nodesWithinDistance should return null when input src is not in graph", localSet);
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when input src is not in graph");
    }
  }
  
  @Test
  public void testNegativeDistance() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "0", -1);
      Assert.assertNull("nodesWithinDistance should return null when distance is negative", localSet);
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance is negative");
    }
  }
  
  @Test
  public void testZeroDistance() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "0", 0);
      Assert.assertNull("nodesWithinDistance should return null when distance is zero", localSet);
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance is zero");
    }
  }
  
  @Test
  public void testOnlyNodeInGraph() {
    UndirectedGraph localUndirectedGraph = new UndirectedGraph();
    localUndirectedGraph.addNode(new Node("lonely"));
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "lonely", 2);
      Assert.assertNotNull("nodesWithinDistance returns null when specified node is only node in graph and distance >= 1", localSet);
      Assert.assertTrue("nodesWithinDistance should return empty Set when specified node is only node in graph and distance >= 1", localSet.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when specified node is only node in graph and distance >= 1");
    }
  }
  
  @Test
  public void testDistance1Undirected() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "0", 1);
      Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in undirected graph", localSet);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in undirected graph", localSet.size() == 4);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", localSet.contains("1"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", localSet.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", localSet.contains("3"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", localSet.contains("5"));
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance = 1 in undirected graph");
    }
  }
  
  @Test
  public void testDistance1Directed() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localDirectedGraph, "1", 1);
      Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in directed graph", localSet);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in directed graph", localSet.size() == 2);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", localSet.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", localSet.contains("5"));
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance = 1 in directed graph");
    }
  }
  
  @Test
  public void testDistanceGreaterThan1Undirected() {
    UndirectedGraph localUndirectedGraph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
    if (localUndirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localUndirectedGraph, "0", 3);
      
      Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in undirected graph", localSet);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in undirected graph", localSet.size() == 6);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("1"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("3"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("4"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("5"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", localSet.contains("6"));
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance > 1 in undirected graph");
    }
  }
  
  @Test
  public void testDistanceGreaterThan1Directed() {
    DirectedGraph localDirectedGraph = GraphBuilder.buildDirectedGraph("graph_builder_test.txt");
    if (localDirectedGraph == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }
    try {
      Set localSet = GraphUtils.nodesWithinDistance(localDirectedGraph, "2", 2);
      
      Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in directed graph", localSet);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in directed graph", localSet.size() == 3);
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", localSet.contains("4"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", localSet.contains("5"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", localSet.contains("6"));
    }
    catch (Exception localException) {
      Assert.fail("nodesWithinDistance throws " + localException + " when distance > 1 in directed graph");
    }
  }
}
