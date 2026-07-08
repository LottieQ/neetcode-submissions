class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int l = 1;
        int r = max;

        while(l < r){
            int sum = 0;
            int curr = l + (r - l) / 2;
            for(int pile : piles){
                sum += ((pile - 1) / curr + 1);
            }
            if(sum <= h){
                r = curr;
            }else{
                l = curr + 1;
            }
        }

        return l;
    }
}
