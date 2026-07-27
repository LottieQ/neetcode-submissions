class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, new ArrayList<>(), 0, 0, target);
        return ans;
    }

    private void backtrack(int[] candidates, List<Integer> path, int sum, int start, int target){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(sum > target || start == candidates.length) return;

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backtrack(candidates, path, sum + candidates[i], i + 1, target);
            path.remove(path.size() - 1);
        }
    }
}
