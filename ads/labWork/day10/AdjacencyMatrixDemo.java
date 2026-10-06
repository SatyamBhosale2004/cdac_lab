public class AdjacencyMatrixDemo {
    static class GraphMatrix {
        private final int[][] matrix;

        GraphMatrix(int vertices) {
            matrix = new int[vertices][vertices];
        }

        void addEdge(int source, int destination) {
            matrix[source][destination] = 1;
            matrix[destination][source] = 1;
        }

        void printMatrix() {
            System.out.println("Adjacency Matrix:");
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printMatrix();
    }
}
