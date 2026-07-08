class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;

        while(right < s.length()){
            char curr = s.charAt(right);
            
            if(!set.contains(curr)){
                ans = Math.max(ans, right - left + 1);
                set.add(curr);
            }else{
                while(s.charAt(left) != curr){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }

        return ans;
    }
}
