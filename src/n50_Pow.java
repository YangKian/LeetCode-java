public class n50_Pow {

    public double myPow(double x, int n) {
        double res = 1;
        long N = Math.abs((long)n); //转换为long，是为了防止n为Integer.MIN_VALUE时，取绝对值后结果溢出

        while(N != 0) {
            if((N & 1) == 1) res *= x;
            x *= x;
            N >>= 1;
        }
        return n >= 0 ? res : 1 / res;
    }
}
