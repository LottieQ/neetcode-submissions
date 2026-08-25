class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[2];

        for(int i = 1; i <= n; i++){
            // i is length
            for(int j = 0; j < n - i + 1; j++){
                // j is start index
                int start = j;
                int end = j + i - 1;
                dp[start][end] = (s.charAt(start) == s.charAt(end)) && (i <= 2 || dp[start + 1][end - 1]);
                if(dp[start][end] && i > ans[1] - ans[0] +1){
                    ans[0] = start;
                    ans[1] = end;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
