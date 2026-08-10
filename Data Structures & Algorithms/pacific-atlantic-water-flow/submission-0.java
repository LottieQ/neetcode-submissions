class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        Queue<int[]> queuePacific = new LinkedList<>();
        Queue<int[]> queueAtlantic = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < heights.length; i++){
            pacific[i][0] = true;
            queuePacific.offer(new int[]{i , 0});
            atlantic[i][heights[0].length - 1] = true;
            queueAtlantic.offer(new int[]{i, heights[0].length - 1});
        }

        for(int j = 0 ; j < heights[0].length; j++){
            pacific[0][j] = true; 
            queuePacific.offer(new int[]{0 , j});
            atlantic[heights.length - 1][j] = true;
            queueAtlantic.offer(new int[]{heights.length - 1, j});
        }

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!queuePacific.isEmpty()){
            int size = queuePacific.size();
            for(int k = 0; k < size; k++){
                int[] curr = queuePacific.poll();
                for(int[] direction : directions){
                    int row = curr[0] + direction[0];
                    int col = curr[1] + direction[1];
                    if(row >= 0 && row < heights.length && col >= 0 && col < heights[0].length){
                        if(heights[row][col] >= heights[curr[0]][curr[1]] && !pacific[row][col]){
                            queuePacific.offer(new int[]{row, col});
                            pacific[row][col] = true;
                        }
                    }
                }
            }
        }

        while(!queueAtlantic.isEmpty()){
            int size = queueAtlantic.size();
            for(int k = 0; k < size; k++){
                int[] curr = queueAtlantic.poll();
                for(int[] direction : directions){
                    int row = curr[0] + direction[0];
                    int col = curr[1] + direction[1];
                    if(row >= 0 && row < heights.length && col >= 0 && col < heights[0].length){
                        if(heights[row][col] >= heights[curr[0]][curr[1]] && !atlantic[row][col]){
                            queueAtlantic.offer(new int[]{row, col});
                            atlantic[row][col] = true;
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}
