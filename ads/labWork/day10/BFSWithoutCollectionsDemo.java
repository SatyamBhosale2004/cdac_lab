public class BFSWithoutCollectionsDemo {
    static class Graph {
        private final int vertices;
        private final int[][] adjacencyMatrix;

        Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyMatrix = new int[vertices][vertices];
        }

        void addEdge(int source, int destination) {
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1;
        }

        void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            int[] queue = new int[vertices];
            int front = 0;
            int rear = 0;

            visited[startVertex] = true;
            queue[rear++] = startVertex;

            System.out.print("BFS Traversal: ");
            while (front < rear) {
                int currentVertex = queue[front++];
                System.out.print(currentVertex + " ");

                for (int neighbor = 0; neighbor < vertices; neighbor++) {
                    if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                        visited[neighbor] = true;
                        queue[rear++] = neighbor;
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

        graph.bfs(0);
    }
}
