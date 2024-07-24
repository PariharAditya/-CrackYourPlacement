import java.util.Arrays;
/*can be done with Kadane */
public class JumpGame {
    static int[] dp; // Made dp global and static

    public static void main(String[] args) {
        
    }

    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fxn(0, nums);
    }

    public boolean fxn(int i, int[] nums) {
        if (i >= nums.length - 1)
            return true;

        if (nums[i] == 0)
            return false;

        if (dp[i] != -1)
            return dp[i] == 1; // Adjusted for boolean return

        int can_reach = i + nums[i];
        for (int jump = i + 1; jump <= can_reach && jump < nums.length; jump++) { // Fixed loop condition
            if (fxn(jump, nums)) {
                dp[i] = 1;
                return true; // True
            }
        }
        dp[i] = 0;
        return false; // False
    }

}
