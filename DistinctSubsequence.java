import java.util.Arrays;

public class DistinctSubsequence {
    int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return generate(0, 0, s, t);
    }

    public int generate(int i, int j, String s, String t) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = generate(i + 1, j + 1, s, t) + generate(i + 1, j, s, t);
        } else {
            dp[i][j] = generate(i + 1, j, s, t);
        }
        return dp[i][j];
    }
}
