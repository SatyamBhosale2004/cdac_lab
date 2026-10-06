import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDemo {
    static class Graph {
        private final List<List<Integer>> adjacencyList;

        Graph(int vertices) {
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        void bfs(int start) {
            boolean[] visited = new boolean[adjacencyList.size()];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.offer(start);

            System.out.print("BFS Traversal: ");
            while (!queue.isEmpty()) {
                int current = queue.poll();
                System.out.print(current + " ");

                for (int neighbor : adjacencyList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.bfs(5);
    }
}
