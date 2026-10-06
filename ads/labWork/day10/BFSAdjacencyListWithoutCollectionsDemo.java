public class BFSAdjacencyListWithoutCollectionsDemo {
    static class Graph {
        private final int vertices;
        private final Node[] adjacencyList;

        static class Node {
            int vertex;
            Node next;

            Node(int vertex, Node next) {
                this.vertex = vertex;
                this.next = next;
            }
        }

        Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new Node[vertices];
        }

        void addEdge(int source, int destination) {
            adjacencyList[source] = new Node(destination, adjacencyList[source]);
            adjacencyList[destination] = new Node(source, adjacencyList[destination]);
        }

        void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            int[] queue = new int[vertices];
            int front = 0;
            int rear = 0;

            visited[startVertex] = true;
            queue[rear++] = startVertex;

            System.out.print("BFS Traversal (Adjacency List): ");
            while (front < rear) {
                int currentVertex = queue[front++];
                System.out.print(currentVertex + " ");

                Node neighborNode = adjacencyList[currentVertex];
                while (neighborNode != null) {
                    int neighbor = neighborNode.vertex;
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue[rear++] = neighbor;
                    }
                    neighborNode = neighborNode.next;
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

    // private static void printBfsDryRunTable() {
    //     System.out.println("BFS Dry Run Table (Adjacency List, start = 0)");
    //     System.out.println("Adjacency order used by code:");
    //     System.out.println("0: 2 -> 1");
    //     System.out.println("1: 4 -> 3 -> 0");
    //     System.out.println("2: 5 -> 0");
    //     System.out.println("3: 1, 4: 1, 5: 2");
    //     System.out.println("Step | Dequeue | Newly Enqueued | Queue After Step | Traversal");
    //     System.out.println("0    | -       | 0              | [0]              | -");
    //     System.out.println("1    | 0       | 2, 1           | [2, 1]           | 0");
    //     System.out.println("2    | 2       | 5              | [1, 5]           | 0 2");
    //     System.out.println("3    | 1       | 4, 3           | [5, 4, 3]        | 0 2 1");
    //     System.out.println("4    | 5       | -              | [4, 3]           | 0 2 1 5");
    //     System.out.println("5    | 4       | -              | [3]              | 0 2 1 5 4");
    //     System.out.println("6    | 3       | -              | []               | 0 2 1 5 4 3");
    //     System.out.println();
    // }
}
