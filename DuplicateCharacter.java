import java.util.HashMap;

public class DuplicateCharacter {
    public static void main(String[] args) {
        DuplicateCharacter dc = new DuplicateCharacter();
        String s = "geeksforgeeks";
        System.out.println(dc.countDuplicate(s));
    }

    public String countDuplicate(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (HashMap.Entry<Character, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() > 1) {
                result.append(entry.getKey()).append(", count = ").append(entry.getValue()).append("\n");
            }
        }
        return result.toString();
    }
}
