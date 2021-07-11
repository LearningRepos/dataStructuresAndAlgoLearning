import java.util.*;

public class App {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D", "E");
        g.addEdge("D", "F");
        g.addEdge("E", "F");
        System.out.println(g.graph);
        System.out.println(g.dfsRecursive("A", new ArrayList<String>(), new HashMap<String, Boolean>()));
        System.out.println(g.dfsIterative("A", new ArrayList<String>(), new HashMap<String, Boolean>()));
        System.out.println(g.bfs("A", new ArrayList<String>(), new HashMap<String, Boolean>()));
    }

    public static class Graph {
        HashMap<String, List<String>> graph = new HashMap<>();

        public List<String> bfs(String vertex, List<String> results, HashMap<String, Boolean> visited) {
            if (!graph.containsKey(vertex) || graph.get(vertex).size() == 0) return results;
            Queue<String> vertices = new ArrayDeque<>();
            vertices.add(vertex);
            visited.put(vertex, true);

            while (!vertices.isEmpty()) {
                String currentVertex = vertices.poll();
                results.add(currentVertex);

                for (String neighbor : graph.get(currentVertex)) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, true);
                        vertices.add(neighbor);
                    }
                }

            }

            return results;
        }

        public List<String> dfsRecursive(String vertex, List<String> results, HashMap<String, Boolean> visited) {
            if (!graph.containsKey(vertex) || graph.get(vertex).size() == 0) return results;
            results.add(vertex);
            visited.put(vertex, true);

            List<String> neighbors = graph.get(vertex);
            for (String neighbor : neighbors) {
                if (!visited.containsKey(neighbor)) dfsRecursive(neighbor, results, visited);
            }

            return results;
        }

        public List<String> dfsIterative(String vertex, List<String> results, HashMap<String, Boolean> visited) {
            if (!graph.containsKey(vertex) || graph.get(vertex).size() == 0) return results;
            Stack<String> vertices = new Stack<>();
            vertices.add(vertex);
            visited.put(vertex, true);

            while (!vertices.isEmpty()) {
                String currentVertex = vertices.pop();
                results.add(currentVertex);

                for (String neighbor : graph.get(currentVertex)) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, true);
                        vertices.add(neighbor);
                    }
                }

            }

            return results;
        }

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
