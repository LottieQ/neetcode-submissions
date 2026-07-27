class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> path){
        ans.add(new ArrayList<>(path));

        if(start >= nums.length){
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            backtrack(nums, i + 1, path);

            path.remove(path.size() - 1);
        }
    }
}
