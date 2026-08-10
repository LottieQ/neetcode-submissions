class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num : nums){
            set.add(num);
        } 

        for(int num : nums){
            if(!set.contains(num - 1)){
                int curr = num;
                int count = 0;
                while(set.contains(curr)){
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
