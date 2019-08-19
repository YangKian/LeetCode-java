public class n5_Longest_Palindromic_Substring {
    //解法一：DP
    public String longestPalindrome(String s) {
        final int size = s.length();
        if(s == null || size == 0) return "";
        int start = 0, maxlen = 0;
        boolean[][] dp = new boolean[size][size];

        for(int i = size - 1; i >= 0; --i) {
            for(int j = i; j < size; ++j) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if(dp[i][j] && j - i + 1> maxlen) {
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    //解法二：中心扩展
    public String longestPalindrome1(String s) {
        int maxlen = 0, start = 0;
        for(int i = 0; i < s.length(); ++i) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if(len > maxlen) {
                maxlen = len;
                start = i - (len - 1 >> 1); //当前的字符串长度i减去回文字符串长度的一半，即是起点
            }
        }
        return s.substring(start, start + maxlen);
    }

    private int expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++right;
            --left;
        }
        return right - left - 1; //((right - 1) - (left + 1) + 1)
    }
}
