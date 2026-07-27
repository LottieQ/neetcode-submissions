class Solution {
    List<String> ans;
    
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder());

        return ans;
    }

    private void backtrack(int n, int leftCount, int rightCount, StringBuilder path){
        if(leftCount == n && rightCount == n){
            ans.add(path.toString());
            return;
        }

        if(leftCount > rightCount){
            path.append(')');
            backtrack(n, leftCount, rightCount + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

        if(leftCount < n){
            path.append('(');
            backtrack(n, leftCount + 1, rightCount, path);
            path.deleteCharAt(path.length() - 1);
        }
        
    }
}
