import java.util.Stack;

public class n20_Valid_Parentheses {

    public boolean isValid(String s) {
        if(s.length() < 1) {
            return true;
        }

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            char word = s.charAt(i);
            if(word == '(' || word =='[' || word == '{') {
                st.push(word);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                char pop_word = st.peek();
                if((pop_word == '(' && word != ')') || (pop_word == '[' && word != ']')
                        || (pop_word == '{' && word != '}')) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
