public class n53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        final int size = nums.length;
        if(size == 0) return 0;

        int ans = nums[0];
        int sum = nums[0];
        for(int i = 1; i < size; ++i) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > ans) ans = sum;
        }
        return ans;
    }
}
