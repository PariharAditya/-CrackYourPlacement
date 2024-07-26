import java.util.Arrays;

public class stock_buy_sell_2 {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return compute(0, 0, prices);
    }

    public int compute(int i, int buy, int[] nums) {
        if (i == nums.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy == 0) {
            dp[i][buy] = Math.max(-nums[i] + compute(i + 1, 1, nums), compute(i + 1, 0, nums));
        } else {
            dp[i][buy] = Math.max(nums[i] + compute(i + 1, 0, nums), compute(i + 1, 1, nums));
        }
        return dp[i][buy];
    }
}
