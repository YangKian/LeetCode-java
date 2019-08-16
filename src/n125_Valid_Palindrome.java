public class n125_Valid_Palindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 0) return false;
        int i = 0, j = s.length() - 1;
        for(; i < j; ++i, --j) {
            while(i < j && !isAlphanumeric(s.charAt(i))) ++i;
            while(i < j && !isAlphanumeric(s.charAt(j))) --j;
            if(i<j && !isEqual(s.charAt(i), s.charAt(j))) return false;
        }
        return true;

    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private boolean isEqual(char a, char b) {
         if(a >= 'A' && a <= 'Z') a += 32;
         if(b >= 'A' && b <= 'Z') b += 32;
         return a == b;
         //补充：
        //统一转成大写：ch & 0b11011111 简写：ch & 0xDF
        //统一转成小写：ch | 0b00100000 简写：ch | 0x20
    }
}
