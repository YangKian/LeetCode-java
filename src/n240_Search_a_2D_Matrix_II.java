public class n240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(target < matrix[i][j]) {
                --j;
            } else if (target > matrix[i][j]) {
                ++i;
            } else {
                return true;
            }
        }
        return false;
    }
}
