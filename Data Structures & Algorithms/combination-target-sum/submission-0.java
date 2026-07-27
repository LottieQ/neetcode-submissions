class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0, 0, target);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> path, int sum, int start, int target){
        if(sum == target){
            ans.add(new ArrayList<>(path));
        }

        if(sum > target) return;

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, path, sum + nums[i], i, target);
            path.remove(path.size() - 1);
        }
    }
}
