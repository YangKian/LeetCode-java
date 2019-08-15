public class n198_House_Robber {

    //写法一
    public int rob(int[] nums) {
        final int size = nums.length;
        if(size == 0) return 0;
        int[] dp = new int[size + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <= size; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[size];
    }

    //写法二
    public int rob1(int[] nums) {
        int preMax=0,currMax=0;
        for(int x :nums){
            int tmp = currMax;
            currMax = Math.max(preMax+x,currMax);
            preMax =tmp;
        }
        return currMax;
    }

}
