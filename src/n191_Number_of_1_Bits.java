public class n191_Number_of_1_Bits {
    //解法一：使用掩码：Time:O(m), m-整数n的二进制位数，Space:O(1)
    public int hammingWeight(int n) {
        int mask = 1, count = 0;
        while(mask != 0) {
            if((mask & n) != 0) {
                ++count;
            }
            mask <<= 1;
        }
        return count;
    }

    //解法二：Time:O(k), k-整数n中1的个数，Space:O(1)
    public int hammingWeight1(int n) {
        int count = 0;
        while(n != 0){
            ++count;
            n &= (n - 1);
        }
        return count;
    }
}
