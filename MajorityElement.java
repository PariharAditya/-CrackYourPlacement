public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count = 1;
            } else if (ans == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
