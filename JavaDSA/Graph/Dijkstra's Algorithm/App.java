import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph();
        g.addVertex("USA");
        g.addVertex("Mexico");
        g.addVertex("Canada");
        g.addEdge("USA", "Mexico", 10);
        g.addEdge("USA", "Canada", 20);
//        g.deleteEdge("USA", "Canada");
//        g.deleteVertex("USA");
        System.out.println(g.graph);
    }

    public static class WeightedGraph {
        HashMap<String, ArrayList<HashMap>> graph = new HashMap<>();

        public void addVertex(String vertex) {
            if (!graph.containsKey(vertex)) graph.put(vertex, new ArrayList<>());
        }

        public void addEdge(String vertex1, String vertex2, int distance) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<HashMap> vertex1List = graph.get(vertex1);
                List<HashMap> vertex2List = graph.get(vertex2);

                if (!vertex1List.stream().anyMatch(object -> object.get("node").equals(vertex2))) {
                    if (!vertex2List.stream().anyMatch(object -> object.get("node").equals(vertex1))) {
                        HashMap vertex1Connection = new HashMap();
                        HashMap vertex2Connection = new HashMap();

                        vertex1Connection.put("node", vertex2);
                        vertex1Connection.put("weight", distance);
                        vertex2Connection.put("node", vertex1);
                        vertex2Connection.put("weight", distance);

                        vertex1List.add(vertex1Connection);
                        vertex2List.add(vertex2Connection);
                    }
                }
            }
        }

        public void deleteEdge(String vertex1, String vertex2) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<HashMap> vertex1List = graph.get(vertex1);
                List<HashMap> vertex2List = graph.get(vertex2);

                if (vertex1List.stream().anyMatch(object -> object.get("node").equals(vertex2))) {
                    if (vertex2List.stream().anyMatch(object -> object.get("node").equals(vertex1))) {
                        graph.put(vertex1, new ArrayList<>(vertex1List.stream()
                                .filter(object -> !object.get("node")
                                        .equals(vertex2))
                                .collect(Collectors.toList()))
                        );
                        graph.put(vertex2, new ArrayList<>(vertex2List.stream()
                                .filter(object -> !object.get("node")
                                        .equals(vertex1))
                                .collect(Collectors.toList()))
                        );
                    }
                }
            }
        }

        public void deleteVertex(String vertex) {
            if (graph.containsKey(vertex)) {
                List<HashMap> vertexList = graph.get(vertex);
                while (vertexList.size() > 0) {
                    deleteEdge(vertex, vertexList.get(0).get("node") + "");
                    vertexList.remove(0);
                }
            }

            graph.remove(vertex);
        }
    }
}
