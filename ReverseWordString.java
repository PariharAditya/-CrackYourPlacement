import java.util.Arrays;
import java.util.Collections;

public class ReverseWordString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +"); // + makes the string like array like in sequence [a, b, c] otherwise it
                                               // would be non-sequence
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }
}
