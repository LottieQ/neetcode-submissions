class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int right = piles[piles.length - 1];
        int left = 1;
        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int pile: piles){
                count += (pile + mid - 1) / mid;
            }
            if(count <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}
