import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int j = i + 1, k = nums.length - 1, target = 0 - nums[i];

                while (j < k) {
                    int sum = nums[j] + nums[k];

                    if (target == sum) {
                        arr.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        while (j < k && nums[j] == nums[j + 1])
                            j++;
                        while (j < k && nums[k] == nums[k - 1])
                            k--;

                        j++;
                        k--;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return arr;
    }

}
