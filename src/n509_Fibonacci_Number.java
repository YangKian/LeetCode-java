public class n509_Fibonacci_Number {
    //解法一：数组迭代，Time:O(n), Space:O(n)
    public int fib(int N) {
        if(N <= 0) return 0;
        if(N == 1) return 1;
        int[] d= new int[N + 1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= N; ++i) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[N];
    }

    //解法二：使用常量代替数组迭代，Time:O(n), Space:O(1)
    public int fib1(int N) {
        if(N <= 0) return 0;
        if(N == 1) return 1;
        int first = 0, second = 1;
        for(int i = 2; i <= N; ++i) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //解法三：递归：Time:O(2^n), Space:O(n)-> 递归深度，即树高
    public int fib2(int N) {
        if(N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

}
