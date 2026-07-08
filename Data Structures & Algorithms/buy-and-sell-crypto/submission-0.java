class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int left = prices[0];
        int right = prices[0];

        for(int i = 0; i < prices.length; i++){
            if(prices[i] > right){
                right = prices[i];
                ans = Math.max(ans, right - left);
            }
            if(prices[i] < left){
                left = prices[i];
                right = prices[i];
            }
        }

        return ans;
    }
}
