public class n867_Transpose_Matrix {

    public int[][] transpose(int[][] A) {
        final int out_length = A.length;
        final int inner_length = A[0].length;
        int[][] res = new int[inner_length][out_length]; //注意位置不要填反了
        for(int i = 0; i < out_length; ++i) {
            for(int j = 0; j < inner_length; ++j) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
