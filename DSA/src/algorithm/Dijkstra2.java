package algorithm;

import java.util.*;

class Dijkstra2 {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int v, int w) { vertex = v; weight = w; }

        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void dijkstra(int V, List<List<Node>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (Node neighbor : adj.get(u)) {
                if (dist[u] + neighbor.weight < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = dist[u] + neighbor.weight;
                    pq.add(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        dijkstra(V, adj, 0);
    }
}
