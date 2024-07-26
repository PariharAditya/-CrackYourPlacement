public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j - i] + nums[j] == target) {
                    ans[0] = j - i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}