public class n769_Max_Chunks_To_Make_Sorted {

    public int maxChunksToSorted(int[] arr) {
        int max = 0, ans = 0;
        for(int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if(max == i) {
                ++ans;
            }
        }
        return ans;
    }
}
