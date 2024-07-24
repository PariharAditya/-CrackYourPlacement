class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        // we've to output number of unique element and assign them 
        // to correct position 
        int count = 1; //since array already sorted and 1st element don't have duplicate
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) nums[count++] = nums[i];
        } 
        return count;
    }
}