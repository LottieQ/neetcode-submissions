class Solution {
    public int rob(int[] nums) {
        int[] total = new int[nums.length];
        int max = 0;
        for(int i = 0; i < 2 && i < nums.length; i++){
            total[i] = nums[i];
            max = Math.max(total[i], max);
        }

        if(nums.length >= 3){
            total[2] = total[0] + nums[2];
            max = Math.max(total[2], max);
        }

        for(int i = 3; i < nums.length; i++){
            total[i] = Math.max(total[i - 2], total[i - 3]) + nums[i];
            max = Math.max(total[i], max);
        }

        return max;
    }
}
