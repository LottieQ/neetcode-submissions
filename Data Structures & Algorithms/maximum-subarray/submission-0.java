class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            currsum = Math.max(num, currsum + num);
            max = Math.max(currsum, max);
        }

        return max;
    }
}
