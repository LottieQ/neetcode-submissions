class Solution {
    public int findDuplicate(int[] nums) {
        int[] check = new int[nums.length];

        for(int num: nums){
            if(check[num] == 1) return num;
            check[num]++;
        }
        return -1;
    }
}
