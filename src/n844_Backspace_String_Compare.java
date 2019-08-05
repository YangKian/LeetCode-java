import java.util.Stack;

public class n844_Backspace_String_Compare {

    //方法一：栈
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        check(s, S);
        check(t, T);
        while(!s.isEmpty() && !t.isEmpty()){
            if(s.pop() != t.pop()) {
                return false;
            }
        }
        return s.isEmpty() && t.isEmpty(); //必须要加该判断，否则会出错，反例："bxj##tw"和"bxj###tw"
    }

    private void check(Stack<Character> stack, String S) {

        for(int i = 0; i < S.length(); ++i){
            char c = S.charAt(i);
            if(c == '#') {
                if(stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
    }

    //方法二：使用StringBuilder构造字符串
    public boolean backspaceCompare1(String S, String T) {
        String a = check(S).toString();
        String b = check(T).toString();
        return a.equals(b);
    }

    private StringBuilder check(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); ++i ){
            char c = s.charAt(i);
            if (c == '#') {
                if (builder.length() != 0) {
                    builder.setLength(builder.length() - 1);
                }
            } else {
                builder.append(c);
            }
        }
        return builder;
    }
}
