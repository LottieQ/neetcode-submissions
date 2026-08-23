class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] min = new int[cost.length + 1];
        min[0] = 0;
        min[1] = 0;

        for(int i = 2; i < min.length; i++){
            min[i] = Math.min(min[i - 1] + cost[i - 1], min[i - 2] + cost[i - 2]);
        }

        return min[cost.length];
    }
}
