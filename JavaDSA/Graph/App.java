import java.util.*;

public class App {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("USA");
        g.addVertex("Canada");
        g.addVertex("Mexico");
        g.addEdge("Canada", "USA");
        g.addEdge("USA", "Mexico");
//        g.removeEdge("USA","Mexico");
//        g.removeVertex("USA");
        System.out.println(g.graph);
    }

    public static class Graph {
        HashMap<String, List<String>> graph = new HashMap<>();

        public void addVertex(String vertex) {
            if (!graph.containsKey(vertex)) graph.put(vertex, new ArrayList<String>());
        }

        public void addEdge(String vertex1, String vertex2) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<String> vertex1List = graph.get(vertex1);
                List<String> vertex2List = graph.get(vertex2);

                if (!vertex1List.contains(vertex2)) vertex1List.add(vertex2);
                if (!vertex2List.contains(vertex1)) vertex2List.add(vertex1);
            }
        }

        public void removeVertex(String vertex) {
            if (graph.containsKey(vertex)) {
                List<String> vertexList = graph.get(vertex);

                while (vertexList.size() > 0) {
                    removeEdge(vertex, vertexList.get(0));
                }
            }
            graph.remove(vertex);
        }

        public void removeEdge(String vertex1, String vertex2) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<String> vertex1List = graph.get(vertex1);
                List<String> vertex2List = graph.get(vertex2);

                if (vertex1List.contains(vertex2) && vertex2List.contains(vertex1)) {
                    vertex1List.remove(vertex2);
                    vertex2List.remove(vertex1);
                }
            }
        }
    }
}
