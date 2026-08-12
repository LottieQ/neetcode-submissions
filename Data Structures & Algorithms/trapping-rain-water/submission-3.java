class Solution {
    public int trap(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;

        while(l <= r){
            if(lMax <= rMax){
                lMax = Math.max(lMax, height[l]);
                area += (lMax - height[l]);
                l++;
            }else{
                rMax = Math.max(rMax, height[r]);
                area += (rMax - height[r]);
                r--;
            }
        }
        return area;
    }
}
