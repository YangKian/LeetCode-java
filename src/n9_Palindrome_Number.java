public class n9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if(x < 0 || x % 10 == 0 && x > 0) return false;

        int temp = x;
        long res = 0;
        while(temp > 0) {
            int num = temp % 10;
            res = res * 10 + num;
            temp /= 10;
        }
        return res == x;
    }
}
