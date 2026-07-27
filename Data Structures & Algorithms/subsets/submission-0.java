class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        buildSubsets(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void buildSubsets(int[] nums, List<Integer> list, int idx){
        ans.add(list);
        if(idx == nums.length) return;

        for(int i = idx ; i < nums.length; i++){
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            buildSubsets(nums, newList, i+1);
        }
    }
}
