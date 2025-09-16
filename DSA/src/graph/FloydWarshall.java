package graph;

class FloydWarshall {
    final static int INF = 99999;

    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        System.out.println("Shortest distances between every pair of vertices:");
        for (int[] row : dist) {
            for (int val : row) {
                System.out.print((val == INF ? "INF" : val) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int INF = FloydWarshall.INF;
        int[][] graph = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        floydWarshall(graph, V);
    }
}
