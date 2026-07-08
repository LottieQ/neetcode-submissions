class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0;
        int ans = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            while(right - left + 1 - maxFreq > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
