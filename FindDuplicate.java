/**
 * FindDuplicate - fast and slow pointer
 */
public class FindDuplicate {

    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        // Phase 1: Finding the intersection point of the two runners.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // Reset one pointer to the start.
        slow = nums[0];
        // Phase 2: Finding the "entrance" to the cycle.
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // or fast, as they are equal here
    }

}