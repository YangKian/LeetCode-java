public class n647_Palindromic_Substrings {

    //解法一：DP
    public int countSubstrings(String s) {
        final int size = s.length();
        if(s == null || size == 0) return 0;

        boolean[][] dp = new boolean[size][size];
        int count = 0;

        for(int i = size - 1; i >=0; --i) {
            for(int j = i; j < size; ++j) {
                if(i == j) {
                    dp[i][j] = true;
                }
                else if(i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j]) ++count;
            }
        }
        return count;
    }

    //解法二：中心扩展
    public int countSubstrings1(String s) {
        final int size = s.length();
        if(s == null || size == 0) return 0;

        int result = 0;
        for(int i = 0; i < size; ++i) {
            result += expand(s, i, i);
            result += expand(s, i, i + 1);
        }
        return result;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }
}
