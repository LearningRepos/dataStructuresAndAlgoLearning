import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
//        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "E", 3);
        g.addEdge("C", "D", 2);
        g.addEdge("C", "F", 4);
        g.addEdge("D", "A", -5);
        g.addEdge("D", "E", 3);
        g.addEdge("D", "F", 1);
        g.addEdge("F", "E", 1);

        g.bellmanFord("A");
    }

    public static class Tuple {
        String Node;
        int distance;

        Tuple(String Node, int distance) {
            this.Node = Node;
            this.distance = distance;
        }
    }

    public static class WeightedGraph {
        HashMap<String, ArrayList<Tuple>> graph = new HashMap<>();

        public void bellmanFord(String start) {
            HashMap<String, Double> distances = new HashMap<>();
            Set<String> vertices = graph.keySet();

            for (String vertex : vertices) {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
            distances.put(start, 0.0);

            for (int i = 0; i < vertices.size() - 1; i++) {
                for (String vertex : vertices) {
                    for(Tuple neighbor : graph.get(vertex)){
                        if(distances.get(vertex) + neighbor.distance < distances.get(neighbor.Node)){
                            distances.put(neighbor.Node, distances.get(vertex) + neighbor.distance);
                        }
                    }
                }
            }

            for (int i = 0; i < vertices.size() - 1; i++) {
                for (String vertex : vertices) {
                    for(Tuple neighbor : graph.get(vertex)){
                        if(distances.get(vertex) + neighbor.distance < distances.get(neighbor.Node)){
                            distances.put(neighbor.Node, Double.NEGATIVE_INFINITY);
                        }
                    }
                }
            }

            System.out.println(distances);
        }

        public void addVertex(String vertex) {
            if (!graph.containsKey(vertex)) graph.put(vertex, new ArrayList<>());
        }

        public void addEdge(String vertex1, String vertex2, int distance) {
            if (graph.containsKey(vertex1) && graph.containsKey(vertex2)) {
                List<Tuple> vertex1List = graph.get(vertex1);
                List<Tuple> vertex2List = graph.get(vertex2);

                if (!vertex1List.stream().anyMatch(object -> object.Node.equals(vertex2))) {
                    if (!vertex2List.stream().anyMatch(object -> object.Node.equals(vertex1))) {
                        vertex1List.add(new Tuple(vertex2, distance));
                    }
                }
            }
        }
    }
}