



import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		if(graph == null || src == null || dest == null) {
			return -1;
		}
		if(graph.containsElement(src) == false || graph.containsElement(dest)== false ){
			return -1;
		}
		if(Objects.equals(src, dest)){
			System.out.println(src + " == " + dest);
			return 0;
		}

		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		boolean result = bfs.bfs(graph.getNode(src), dest);
		System.out.println(result);

		if (result == false) {
			return -1;
		}
		System.out.println();
		System.out.println(bfs.marked);
		System.out.println(bfs.graph.getNumNodes());
		return bfs.marked.size()> 1 ? bfs.marked.size() / 2: 1;
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
