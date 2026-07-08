class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int r = 0;
        int currMax = 0;
        int ans = 0;

        while(r < s.length()){
            char c = s.charAt(r);
            count[c - 'A']++;
            currMax = Math.max(currMax, count[c - 'A']);

            if(r - l + 1 - currMax > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;

    }
}
