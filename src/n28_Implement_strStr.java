public class n28_Implement_strStr {

    //双指针同时遍历两个字符串，时间复杂度：O((m - n + 1) * n), 空间复杂度：O(1);
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int m = haystack.length(), n = needle.length();
        //外层循环只需执行到 m-n+1 项即可，因为超过该项以后，剩余的字符串已经不足以完全匹配needle
        for(int i = 0; i < m - n + 1; ++i) {
            int j = i, k = 0;
            //最坏情况出现在只有最后一个字符不同的时候，此时每次遍历都需要完整的扫描needle的长度
            for(; j < m && k < n && haystack.charAt(j) == needle.charAt(k); ++k, ++j) {};
            if(k == n) {
                return i;
            }
        }
        return -1;
    }
}
