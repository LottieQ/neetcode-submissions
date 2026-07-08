class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> idx = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++){
            int currHeight = (i == heights.length ? 0 : heights[i]);
            while(!idx.isEmpty() && currHeight < heights[idx.peek()]){
                int height = heights[idx.pop()];
                int width = (idx.isEmpty() ? i : i - idx.peek() - 1);
                max = Math.max(max, height * width);
            }
            idx.push(i);
        }

        return max;
    }
}
