public class n8_String_to_Integer_atoi {

    public int myAtoi(String str) {
        //start代表数字起始的位置，cur是遍历时指针的位置
        int start = 0, cur = 0, len = str.length();
        boolean neg = false;

        //去除前面的空格，处理边界：全为空格时返回0
        while(cur < len && str.charAt(cur) == ' ') ++cur;
        if(cur == len) return 0;

        //检查是否有符号
        if(str.charAt(cur) == '+') {
            ++cur;
        } else if (str.charAt(cur) == '-') {
            ++cur;
            neg = true;
        }

        //去除数字高位上的0
        while(cur < len && str.charAt(cur) == '0') ++cur;
        start = cur;

        //遍历记录数字的位数，如果cur == start，说明没有数字被扫描到，返回0
        while(cur < len && str.charAt(cur) >= '0' && str.charAt(cur) <= '9') ++cur;
        if(cur == start) return 0;

        //根据位数先做初始判断，若位数超过10，说明超过了int的范围，根据符号返回极大或极小值
        if(cur - start > 10) {
            if(neg) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        //用long格式来存储数字，完成转换，并判断符号
        long number = 0;
        for(int i = start; i < cur; ++i) {
            number = number * 10 + (str.charAt(i) - '0');
        }
        number = neg ? -number : number;

        //检查结果是否超限，不超限则转为int
        if(number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)number;
        }
    }
}
