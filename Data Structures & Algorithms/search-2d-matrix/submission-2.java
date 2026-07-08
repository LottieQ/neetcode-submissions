class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowUp = 0;
        int rowDn = matrix.length;
        while(rowUp < rowDn - 1){
            int mid = rowUp + (rowDn - rowUp) / 2;
            int num = matrix[mid][0];
            if(num <= target) rowUp = mid;
            else rowDn = mid;
        }

        int row = rowUp;
        int i = 0;
        int j = matrix[0].length - 1;

        while(i <= j){
            int mid = i + (j - i) / 2;
            int num = matrix[row][mid];
            if(num == target){
                return true;
            }else if(num > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }

        return false;
    }
}
