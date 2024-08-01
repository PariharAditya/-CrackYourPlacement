import java.util.*;

/*
 * the sorting is used to transform each string into a canonical 
 * form that can be used as a key in the hash map. This ensures that all anagrams, 
 * which are words that can be rearranged to form each other, will have the same key.
 * Canonical Form: The sorted string serves as a canonical form (key) for all anagrams.
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public boolean isAnagramn(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}
