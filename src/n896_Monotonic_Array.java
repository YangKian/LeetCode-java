public class n896_Monotonic_Array {

    public boolean isMonotonic(int[] A) {
        int flag =0, i = 0;
        while(++i < A.length) {
            int min = A[i] - A[i - 1];
            if(min == 0) continue;
            if(min * flag < 0 && flag != 0) return false;
            flag = min;
        }
        return true;
    }
}
