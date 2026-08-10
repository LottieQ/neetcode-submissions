class Solution {
    int fresh = 0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }


        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] curr = queue.poll();
                bfs(grid, curr[0], curr[1], queue);
            }
            count++;
        }


        return fresh > 0 ? -1 : count;
    }

    private void bfs(int[][] grid, int row, int col, Queue<int[]> queue){
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for(int[] direction: directions){
            int i = row + direction[0];
            int j = col + direction[1];
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
                continue;
            }
            grid[i][j] = 2;
            fresh--;
            queue.offer(new int[]{i, j});
        }
    }
}
