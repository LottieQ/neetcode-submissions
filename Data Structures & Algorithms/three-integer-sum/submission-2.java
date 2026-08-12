class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                if((r < nums.length - 1 && nums[r] == nums[r + 1]) || nums[l] + nums[r] > -nums[i]){
                    r--;
                }else if((l > i + 1 && nums[l] == nums[l - 1]) || nums[l] + nums[r] < -nums[i]){
                    l++;
                }else{
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[l]);
                    curr.add(nums[r]);
                    ans.add(curr);
                    r--;
                    l++;
                }
            }
        }

        return ans;
    }
}
