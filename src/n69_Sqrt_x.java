public class n69_Sqrt_x {
    //方法一：二分法：Time：O(logn)，Space：O(1)
    public int mySqrt(int x) {
        long low = 0, high = x;
        while(low <= high) { //注意等号不要漏
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if(square < x) {
                low = mid + 1;
            } else if(square > x) {
                high = mid - 1;
            } else {
                return (int)mid;
            }
        }
        return (int)high; //对于取不到整数解的情况，如根号8，返回的是（int）high
    }

    //方法二：牛顿迭代：Time：O(logn)，Space：O(1)
    public int mySqrt1(int x) {
        long n = x;
        while(n * n > x) {
            n = (n + x / n) / 2;
        }
        return (int)n;
    }
}
