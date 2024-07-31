public class RabinKarp {
    public final static int d = 256; // Number of characters in the input alphabet

    public static void search(String pat, String txt, int q) {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        int p = 0; // Hash value for pattern
        int t = 0; // Hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                // If the hash values match, check the characters one by one
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // If p == t and pat[0...m-1] == txt[i...i+m-1], then pattern is found
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + 1)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // A prime number
        search(pat, txt, q);
    }
}