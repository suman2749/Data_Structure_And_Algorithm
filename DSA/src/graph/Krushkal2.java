package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Krushkal2 {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
        public int compareTo(Edge other) { return this.weight - other.weight; }
    }

    static int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x), yroot = find(parent, y);
        if (rank[xroot] < rank[yroot]) parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot]) parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    public static void kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            int x = find(parent, e.src), y = find(parent, e.dest);
            if (x != y) {
                result.add(e);
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in MST:");
        for (Edge e : result)
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10), new Edge(0, 2, 6),
                new Edge(0, 3, 5), new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        );

        kruskalMST(V, edges);
    }
}
