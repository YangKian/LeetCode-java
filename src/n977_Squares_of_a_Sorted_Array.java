public class n977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        final int size = A.length;

        int partition = 0;
        while(partition < size && A[partition] < 0){ //注意此处要先判断partition<size，否则A[partition]会下标超限
            partition++;
        }

        int right = partition;
        int left = partition - 1;

        int[] res = new int[size];

        for(int idx = 0; idx < size; ++idx) {
            if(right >= size) {
                res[idx] = A[left] * A[left];
                --left;
                continue;
            }

            if(left < 0) {
                res[idx] = A[right] * A[right];
                ++right;
                continue;
            }

            if(A[left] * A[left] < A[right] * A[right]) {
                res[idx] = A[left] * A[left];
                --left;
            } else {
                res[idx] = A[right] * A[right];
                ++right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        n977_Squares_of_a_Sorted_Array res = new n977_Squares_of_a_Sorted_Array();
        int[] a = {-1};
        int[] ans = res.sortedSquares(a);
        System.out.println(ans);
    }
}
