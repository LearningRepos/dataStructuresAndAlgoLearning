import java.util.*;

public class App {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("Algebra 1");
        g.addVertex("Math 1");
        g.addVertex("Geometry");
        g.addVertex("Math 2");
        g.addVertex("Math 3");
        g.addVertex("Math Analysis");
        g.addVertex("Stats");

        g.addEdge("Algebra 1", "Math 2");
        g.addEdge("Algebra 1", "Geometry");
        g.addEdge("Math 1", "Geometry");
        g.addEdge("Math 1", "Math 2");
        g.addEdge("Geometry", "Math 3");
        g.addEdge("Geometry", "Math Analysis");
        g.addEdge("Geometry", "Stats");
        g.addEdge("Math 2", "Math 3");
        g.addEdge("Math 2", "Math Analysis");
        g.addEdge("Math 2", "Stats");
        System.out.println(g.graph);
        g.topologicalSort();
    }

    public static class Graph {
        HashMap<String, List<String>> graph = new HashMap<>();

        public void topologicalSort() {
            HashMap<String, Boolean> visited = new HashMap<>();
            List<String> results = new LinkedList<>();
            Set<String> allNodes = graph.keySet();

            for (String startNode : allNodes) {
                if (!visited.containsKey(startNode)) {
                    dfs(startNode, visited, results);
                }
            }

            System.out.println(results);
        }

        public void dfs(String currNode, HashMap<String, Boolean> visited, List<String> results) {
            visited.put(currNode, true);

            for (String neighbor : graph.get(currNode)) {
                if (!visited.containsKey(neighbor)) dfs(neighbor, visited, results);
            }

            results.add(0, currNode);
        }

        public void addVertex(String vertex) {
            if (!graph.containsKey(vertex)) graph.put(vertex, new ArrayList<String>());
        }

        public void addEdge(String vertex1, String vertex2) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<String> vertex1List = graph.get(vertex1);

                if (!vertex1List.contains(vertex2)) vertex1List.add(vertex2);
            }
        }
    }
}