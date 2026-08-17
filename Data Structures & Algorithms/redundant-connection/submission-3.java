class Solution {
    Set<Integer> cycle = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        dfs(visited, parent, graph, 1, -1);

        // 从后往前找最后一条属于 cycle 的 edge
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];

            if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    private boolean dfs(
        boolean[] visited,
        int[] parent,
        List<List<Integer>> graph,
        int curr,
        int prev
    ) {
        visited[curr] = true;
        parent[curr] = prev;

        for (int neighbor : graph.get(curr)) {
            if (neighbor == prev) {
                continue;
            }

            if (visited[neighbor]) {
                // curr -> ... -> neighbor 这一整条都是 cycle
                cycle.add(neighbor);

                int node = curr;

                while (node != neighbor) {
                    cycle.add(node);
                    node = parent[node];
                }

                return true;
            }

            if (dfs(visited, parent, graph, neighbor, curr)) {
                return true;
            }
        }

        return false;
    }
}