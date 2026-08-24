class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        return Math.max(findMax(nums, 0, n - 1), findMax(nums, 1, n - 1));
    }

    private int findMax(int[] nums, int start, int n){
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[i] = nums[start + i];
            }
            if(i == 1){
                dp[i] = Math.max(dp[i - 1], nums[start + i]);
            }

            if(i > 1){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
            }
        }
        return dp[n - 1];
    }
}
