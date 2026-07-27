class Solution {
    List<List<String>> ans;
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int start, List<String> path){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(!isPalindrome(s, start, end)){
                continue;
            }

            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
