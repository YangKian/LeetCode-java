import java.util.Arrays;

public class n155_Min_Stack {
    private int[] s = new int[10];
    private int[] ms = new int[10];
    int top = -1;

    /** initialize your data structure here. */
    public n155_Min_Stack() {
    }

    public void push(int x) {
        if(s.length - 1 == top) {
            s = Arrays.copyOf(s, s.length * 2);
            ms = Arrays.copyOf(ms, ms.length * 2);
        }

        //注意此处的下标递增
        s[top+1] = x;
        if (top < 0) {
            ms[top+1] = x;
        }
        else {
            ms[top+1] = x < ms[top] ? x : ms[top];
        }
        ++top;
    }

    public void pop() {
        if(top >=0) {
            s[top--] = 0;
        }
    }

    public int top() {
        if(top < 0) {
            return 0;
        }
        return s[top];
    }

    public int getMin() {
        if(top < 0) {
            return 0;
        }
        return ms[top];
    }
}

