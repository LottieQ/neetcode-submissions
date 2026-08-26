class Solution {
    int min;
    public int coinChange(int[] coins, int amount) {
        min = Integer.MAX_VALUE;
        backtrace(coins, 0, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void backtrace(int[] coins, int start, int remains, int count){
        if(remains == 0){
            min = Math.min(min, count);
            return;
        }

        for(int i = start; i < coins.length; i++){
            if(coins[i] > remains){
                continue;
            }
            backtrace(coins, i, remains - coins[i], count + 1);
        }
    }
}
