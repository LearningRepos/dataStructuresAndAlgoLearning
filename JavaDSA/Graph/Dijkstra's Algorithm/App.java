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
        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "E", 3);
        g.addEdge("C", "D", 2);
        g.addEdge("D", "E", 3);
        g.addEdge("C", "F", 4);
        g.addEdge("D", "F", 1);
        g.addEdge("F", "E", 1);

        g.dijkstraAlgo("A", "E");
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
        HashMap<String, ArrayList<HashMap>> graph = new HashMap<>();

        public void dijkstraAlgo(String startVertex, String endVertex) {
            HashMap<String, Integer> distances = new HashMap<>();
            HashMap<String, String> previousNodes = new HashMap<>();
            PriorityQueue<Tuple> q = new PriorityQueue<>((Tuple t1, Tuple t2) -> t1.distance - t2.distance);

            distances.put(startVertex, 0);
            previousNodes.put(startVertex, null);
            q.offer(new Tuple(startVertex, 0));

            while (!q.isEmpty()) {
                Tuple currTuple = q.poll();
                if (currTuple.Node.equals(endVertex)) {
                    break;
                } else {
                    List<HashMap> vertexList = graph.get(currTuple.Node);

                    for (HashMap neighbor : vertexList) {
                        int distance = (int) neighbor.get("weight") + distances.get(currTuple.Node);

                        if (!distances.containsKey(neighbor.get("node")) || distance < distances.get(neighbor.get("node"))) {
                            distances.put((String) neighbor.get("node"), distance);
                            previousNodes.put((String) neighbor.get("node"), currTuple.Node);
                            q.add(new Tuple((String) neighbor.get("node"), distance));
                        }
                    }
                }
            }
            System.out.println(distances);
            System.out.println(previousNodes);
        }

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
