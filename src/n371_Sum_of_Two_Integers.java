public class n371_Sum_of_Two_Integers {
    //解法一：递归
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    //解法二：迭代
    public int getSum1(int a, int b) {
        while(b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
