class Solution {
    private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for(String word : words){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        for(int row = 0 ; row < board.length; row++){
            for(int col = 0 ; col < board[0].length; col++){
                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    private void dfs(
        char[][] board,
        int row,
        int col,
        TrieNode node,
        List<String> result
    ){
        if(
            row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length
        ){
            return;
        }

        char c = board[row][col];

        if(c == '#'){
            return;
        }

        TrieNode next = node.children[c - 'a'];

        if(next == null){
            return;
        }

        if(next.word != null){
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = '#';

        dfs(board, row - 1, col, next, result);
        dfs(board, row + 1, col, next, result);
        dfs(board, row, col - 1, next, result);
        dfs(board, row, col + 1, next, result);

        board[row][col] = c;
    }


    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
}
