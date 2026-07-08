class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        Set<Character> dup = new HashSet<>();

        while(r < s.length()){
            if(!dup.add(s.charAt(r))){
                while(s.charAt(l) != s.charAt(r)){
                    dup.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
