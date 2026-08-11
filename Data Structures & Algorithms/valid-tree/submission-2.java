class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        queue.offer(0);
        visited[0] = true;
        int count = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int neighbor : graph.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return count == n;
    }
}
