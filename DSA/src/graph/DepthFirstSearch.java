package graph;

import java.util.*;

public class DepthFirstSearch {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int v, int w) {
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.print("DFS Traversal: ");
        g.dfs(2);
    }
}
