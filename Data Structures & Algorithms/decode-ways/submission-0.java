class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if(n == 1) return dp[0];
        
        for(int i = 1; i < n; i++){
            int one = s.charAt(i) - '0';
            int two = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');

            if(one != 0){
                dp[i] += dp[i - 1];
            }
            if(two <= 26 && two >= 10){
                if(i == 1){
                    dp[i]++;
                }else{
                    dp[i] += dp[i - 2];
                }  
            }
        }
        
        return dp[n - 1];
    }
}
