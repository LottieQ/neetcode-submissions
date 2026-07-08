class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == left){
                return Math.min(nums[left], nums[right]);
            }else if(nums[mid] > nums[left] && nums[left] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return -1;
    }
}
