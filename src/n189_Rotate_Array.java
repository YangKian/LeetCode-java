
public class n189_Rotate_Array {
    //方法一：借助辅助数组，先放入后k个数，再放入剩余的数，最后将结果拷贝回原数组；
    //Time: O(n); Space: O(n)
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;

        int len = nums.length, m = k % len, i = 0; //注意，k的大小可能大于原数组，所以多了一步取模的操作
        int[] temp = new int[len];
        for(int j = len - m; j < len; ++j) temp[i++] = nums[j];
        for(int j = 0; j < len - m; ++j) temp[i++] = nums[j];
        for(int j = 0; j < len; ++j) nums[j] = temp[j];
    }

    //方法二：原地翻转：Time: O(n); Space: O(1)
    public void rotate1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;

        int len = nums.length, m = k % len;

        reverse(nums, 0, len - 1); //先将整个数组进行翻转
        reverse(nums, 0, m - 1); //再翻转前m个数；
        reverse(nums, m, len - 1); //最后翻转剩下的数
    }

    private void reverse(int[] nums, int s, int e) {
        while(s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            ++s;
            --e;
        }
    }
}
