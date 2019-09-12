public class n387_First_Unique_Character_in_a_String {
    //Time：O(n); Space：O(m)
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;

        int[] count = new int[26];
        for(int i = 0; i < s.length(); ++i) { //两次遍历，第一次统计出字符出现的次数，第二次找出第一个不重复的字符下标
            int pos = s.charAt(i) - 'a';
            ++count[pos];
        }
        for(int i = 0; i < s.length(); ++i) {
            if(count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
