class Solution {
    boolean binarysearch(int mat[][], int search, int r) {
        int left = 0;
        int right = mat[0].length - 1;  // fix here
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search == mat[r][mid]) {
                return true;
            }
            if (search < mat[r][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        int up=0,down=row-1;
        while(up<=down) {
            int mid=up+((down-up)/2);
            if (target >= matrix[mid][0] && target <= matrix[mid][col - 1]) {
                if (target == matrix[mid][0] || target == matrix[mid][col - 1]) {
                    return true;
                }
                return binarysearch(matrix, target, mid);
            }
            if(target<=matrix[mid][0])
            {
                down=mid-1;
            }
            else
            {
                up=mid+1;
            }
        }
        return false;
    }
}