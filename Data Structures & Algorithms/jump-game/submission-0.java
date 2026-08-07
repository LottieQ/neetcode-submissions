class Solution {
    public boolean canJump(int[] nums) {
        int idx = nums.length - 1;

        while(idx > 0){
            int curr = idx - 1;
            while(curr >= 0 && nums[curr] < idx - curr){
                curr--;
            }
            if(curr < 0) return false;
            idx = curr;
        }

        return true;
    }
}
