class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int ans = (right - left) * Math.min(heights[left], heights[right]);

        while(left < right){
            if(heights[left] > heights[right]){
                right--;
                if(heights[right] > heights[right + 1]){
                    ans = Math.max(ans, (right - left) * Math.min(heights[left], heights[right]));
                }
            }else{
                left++;
                if(heights[left] > heights[left - 1]){
                    ans = Math.max(ans, (right - left) * Math.min(heights[left], heights[right]));
                }
            }
        }

        return ans;
    }
}
