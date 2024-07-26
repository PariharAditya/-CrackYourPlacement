import java.util.HashMap;

public class SubarraySum {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainder < 0)
                remainder += k; // -ve case add k to the remainder

            count += mpp.getOrDefault(remainder, 0); // found count

            mpp.put(remainder, mpp.getOrDefault(remainder, 0) + 1); // new subarray
        }
        return count;
    }
}
