class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowCheck = new HashSet[9];
        Set<Integer>[] colCheck = new HashSet[9];
        Set<Integer>[] boxCheck = new HashSet[9];

        Arrays.setAll(rowCheck, i -> new HashSet<>());
        Arrays.setAll(colCheck, i -> new HashSet<>());
        Arrays.setAll(boxCheck, i -> new HashSet<>());

        for(int i = 0 ; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                int boxIdx = i / 3 + j / 3 * 3;

                if(!rowCheck[i].add(num)) return false;
                if(!colCheck[j].add(num)) return false;
                if(!boxCheck[boxIdx].add(num)) return false;
            }
        }
        return true;
    }
}
