import java.util.Arrays;

public class n268_Missing_Number {

    //解法一：使用异或算法
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for(int i = 0; i < nums.length; ++i) {
            result ^= nums[i] ^ i;
        }
        return result;
    }

    //解法二：Time:O(nlogn)， Space:O(1)
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        if(nums[size - 1] != size) {
            return size;
        }
        if(nums[0] != 0) {
            return 0;
        }
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] - nums[i - 1] != 1) {
                return nums[i - 1] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        n268_Missing_Number res = new n268_Missing_Number();
        System.out.println(res.missingNumber(nums));
    }
}
