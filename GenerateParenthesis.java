import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParenthesis
 */
public class GenerateParenthesis {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateCombination(0, 0, "", n);
        return ans;
    }

    void generateCombination(int left, int right, String s, int n) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (left < n)
            generateCombination(left + 1, right, s + '(', n);

        if (right < left)
            generateCombination(left, right + 1, s + ')', n);

    }

}