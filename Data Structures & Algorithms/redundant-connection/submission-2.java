class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;        
        int[] roots = new int[n];

        for(int i = 0; i < n; i++){
            roots[i] = i;
        }

        for(int[] edge : edges){
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);

            if(root1 == root2){
                return edge;
            }
            roots[root2] = root1;
        }

        return new int[]{-1, -1};
    }

    private int find(int[] roots, int i){
        if(roots[i] != i){
            roots[i] = find(roots, roots[i]);
        }
        return roots[i];
    }
}
