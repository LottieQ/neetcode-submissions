class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int height = matrix.length;

        int left = 0;
        int right = width * height - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int row = mid / width;
            int col = mid % width;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
