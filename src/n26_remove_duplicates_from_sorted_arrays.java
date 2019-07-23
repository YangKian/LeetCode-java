public class n26_remove_duplicates_from_sorted_arrays {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int j = 0;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
}