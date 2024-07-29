import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{')
                stk.push('}');
            else if (s.charAt(i) == '(')
                stk.push(')');
            else if (s.charAt(i) == '[')
                stk.push(']');
            else if (stk.isEmpty() || stk.pop() != s.charAt(i))
                return false;
        }
        return stk.isEmpty();
    }
}
