class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0, col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            int num=matrix[row][col];
            if(num>target){
                col--;
            }
            else if(num<target){
                row++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}