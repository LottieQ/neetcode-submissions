class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int num: nums){
            if(!set.contains(num - 1)){
                int temp = num;
                int count = 0;
                while(set.contains(temp)){
                    count++;
                    temp++;
                }
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }
}
