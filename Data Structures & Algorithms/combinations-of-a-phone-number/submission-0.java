class Solution {
    String[] map;
    List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length() == 0) return ans;

        map = new String[8];
        map[0] = "abc";
        map[1] = "def";
        map[2] = "ghi";
        map[3] = "jkl";
        map[4] = "mno";
        map[5] = "pqrs";
        map[6] = "tuv";
        map[7] = "wxyz";

        backtrack(digits, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder path){
        if(index == digits.length()){
            ans.add(path.toString());
            return;
        }

        String curr = map[digits.charAt(index) - '2'];
        for(char c : curr.toCharArray()){
            path.append(c);
            backtrack(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
