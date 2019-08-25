import java.util.Arrays;

public class n768_Max_Chunks_To_Make_Sorted_II {
    //方法一：
    public int maxChunksToSorted(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);
        Arrays.sort(res);

        int ans = 0;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum1 += arr[i];
            sum2 += res[i];
            if(sum1 == sum2) ++ans;
        }
        return ans;
    }

    //方法二：
    public int maxChunksToSorted1(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            max[i] = Math.max(arr[i], max[i - 1]);
        }

        int ans = 0, min = Integer.MAX_VALUE;
        for(int j = arr.length - 1; j >=0; --j) {
            if(min >= max[j]) {
                ++ans;
            }
            min = Math.min(min, arr[j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        n768_Max_Chunks_To_Make_Sorted_II res = new n768_Max_Chunks_To_Make_Sorted_II();
        int[] arr = new int[]{2,1,3,4,4};
        int result = res.maxChunksToSorted1(arr);
        System.out.println(result);
    }
}
