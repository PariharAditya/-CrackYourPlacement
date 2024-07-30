import java.util.Stack;

/**
 * SimplifyPath
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String ans = "";

        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stk.push(s);
            }
        }

        for (String dir : stk) {
            ans = ans + "/" + dir;
        }

        return ans.isEmpty() ? "/" : ans;
    }
}
