class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len + 1];
        int[] suffix = new int[len + 1];
        int[] res = new int[len];

        prefix[0] = 1;
        suffix[len] = 1;
        for(int i = 0; i < len; i++){
            prefix[i + 1] = prefix[i] * nums[i];
            suffix[len - 1 - i] = suffix[len - i] * nums[len - 1 - i];
        }

        for(int j = 0; j < len; j++){
            res[j] = prefix[j] * suffix[j + 1];
        }
        
        return res;
    }
}  
