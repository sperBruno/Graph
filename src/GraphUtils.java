
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		int result = -1;
		if (graph == null || src == null || dest == null || !graph.containsElement(src)
				|| !graph.containsElement(dest)) {
			return result;
		}

		if (Objects.equals(src, dest)) {
			return 0;
		}

		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		boolean nodeExist = bfs.bfs(graph.getNode(src), dest);
		if (!nodeExist) {
			return result;
		}
		return bfs.marked.size() > 1 ? bfs.marked.size() / 2 : 1;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		if (graph == null || src == null || distance <= 0 || !graph.containsElement(src)) {
			return null;
		}

		Node nodeSrc = graph.getNode(src);

		Set<String> nodes = nodesWithinDistance(graph, nodeSrc, distance, 0, new HashSet<String>());
		nodes.remove(src);

		return nodes;
	}

	private static Set<String> nodesWithinDistance(Graph graph, Node nodeSrc, int distance, int currentDistance,
			Set<String> result) {

		if (distance == currentDistance) {
			return result;
		} else {
			Set<Edge> adjacencySetsAux = new HashSet<Edge>();
			adjacencySetsAux = graph.adjacencySets.get(nodeSrc);

			if (adjacencySetsAux != null) {
				for (Edge edge : adjacencySetsAux) {
					String adjacencyNodeLabel = edge.getDestination().getElement();
					result.add(adjacencyNodeLabel);
					nodesWithinDistance(graph, edge.getDestination(), distance, currentDistance + 1, result);
				}
			}
		}

		return result;
	}

	public static boolean isHamiltonianPath(Graph graph, List<String> values) {
		ArrayList<Node> markedNodes = new ArrayList<>();
		boolean result = false;
		if (graph != null && values != null && !values.isEmpty() && values.get(0) == values.get(values.size() - 1)) {
				for (int i = 0; i < values.size() - 1; i++) {
					if (graph.containsElement(values.get(i))) {
						Node node = graph.getNode(values.get(i));
						Node nodeNext = graph.getNode(values.get(i + 1));
						Set<Edge> adjacencySetsAux = graph.adjacencySets.get(node);
						if (SetContainsValue(adjacencySetsAux, nodeNext)) {
							if (markedNodes.contains(node)) {
								return false;
							}
							markedNodes.add(node);
						} else {
							return false;
						}
					}
					result = true;
				}

			Set<Node> nodesOfGraph = graph.getAllNodes();
			nodesOfGraph.removeAll(markedNodes);
			if (!nodesOfGraph.isEmpty())
				return false;
		}
		return result;
	}

	private static boolean SetContainsValue(Set<Edge> set, Node node) {
		boolean result = false;
		for (Edge edge : set) {
			if (edge.getDestination().element.equals(node.element))
				result = true;
		}
		return result;
	}

}
