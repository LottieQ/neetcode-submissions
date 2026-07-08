class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++){
            int currHeight = (i == heights.length) ? 0 : heights[i];
            
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int right = i;
                int left = (stack.isEmpty() ? -1 : stack.peek());
                int area = (right - left - 1) * height;
                max = Math.max(area, max);
            }
            stack.push(i);
        }

        return max;
    }
}
