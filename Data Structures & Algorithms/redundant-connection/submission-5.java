class Solution {

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

        Set<Integer> cycle = dfs(visited, graph, 1, -1);

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];

            if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    private Set<Integer> dfs(
        boolean[] visited,
        List<List<Integer>> graph,
        int curr,
        int prev
    ) {
        visited[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (neighbor == prev) {
                continue;
            }

            if (visited[neighbor]) {
                Set<Integer> cycle = new HashSet<>();
                cycle.add(neighbor);
                cycle.add(curr);
                return cycle;
            }

            Set<Integer> res = dfs(visited, graph, neighbor, curr);

            if (!res.isEmpty()) {

                // cycle 已经闭合，不要再加外面的节点
                if (res.contains(-1)) {
                    return res;
                }

                // curr 是 cycle 起点
                if (res.contains(curr)) {
                    res.add(-1);
                    return res;
                }

                // 还没回到 cycle 起点
                res.add(curr);
                return res;
            }
        }

        return new HashSet<>();
    }
}