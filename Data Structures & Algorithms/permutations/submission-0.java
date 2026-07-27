class Solution {
    
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        int[] curr = new int[nums.length];
        Arrays.fill(curr, -11);
        Queue<Integer> remains = new LinkedList<>();
        for(int num: nums){
            remains.offer(num);
        }
        backtrack(remains, curr);
        return ans;
    }
    
    private void backtrack(Queue<Integer> remains, int[] curr){
        if(remains.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int num : curr){
                list.add(num);
            }
            ans.add(list);
            return;
        }

        int num = remains.poll();
        for(int i = 0; i < curr.length; i++){
            if(curr[i] == -11){
                curr[i] = num;
                backtrack(new LinkedList<>(remains), curr);
                curr[i] = -11;
            }
        }
    }
}
