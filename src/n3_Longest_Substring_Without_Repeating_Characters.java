import java.util.HashMap;

public class n3_Longest_Substring_Without_Repeating_Characters {

    //解法一：
    public int lengthOfLongestSubstring(String s) {
        final int size = s.length();
        if(size == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int start = 0, end = 0; end < size; ++end) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    //解法二：
    public int lengthOfLongestSubstring2(String s) {
        final int size = s.length();
        if(size == 0) return 0;

        int[] store = new int[128];
        int ans = 0;
        for(int start = 0, end = 0; end < size; ++end) {
            char word = s.charAt(end);
            if(store[word] != 0) {
                start = Math.max(store[word], start);
            }
            ans = Math.max(end - start + 1, ans);
            store[word] = end + 1;
        }
        return ans;
    }

}
