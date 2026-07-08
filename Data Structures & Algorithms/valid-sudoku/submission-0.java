class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> colCheck= new HashMap<>();
        HashMap<Integer, Set<Character>> rowCheck= new HashMap<>();
        HashMap<String, Set<Character>> boxCheck= new HashMap<>();

        for(int col = 0; col < 9; col++){
            for(int row = 0; row < 9; row++){
                if(board[row][col] == '.') continue;

                char curr = board[row][col];
                colCheck.putIfAbsent(col, new HashSet<>());
                rowCheck.putIfAbsent(row, new HashSet<>());

                int x = row / 3;
                int y = col / 3;
                String key = x + "," + y;
                boxCheck.putIfAbsent(key, new HashSet<>());

                if(colCheck.get(col).contains(curr) || rowCheck.get(row).contains(curr) || boxCheck.get(key).contains(curr)){
                    return false;
                }
                colCheck.get(col).add(curr);
                rowCheck.get(row).add(curr);
                boxCheck.get(key).add(curr);
            }
        }
        return true;
    }
}
