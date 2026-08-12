class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int lMax = 0, rMax = 0;
        int area = 0;

        while(l < r){
            if(heights[l] > lMax || heights[r] > rMax){
                area = Math.max(area, (r - l) * Math.min(heights[l], heights[r]));
            }
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return area;
    }
}
