package algorithm;

import java.util.Arrays;

public class PrimsAlgorithm2 {
    public static void primMST(int V, int[][] graph) {
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
    }

    private static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v]; minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primMST(V, graph);
    }
}

