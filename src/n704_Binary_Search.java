public class n704_Binary_Search {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;

        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low >> 1);
            if(target > nums[mid]) low = mid + 1;
            else if(target < nums[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }
}
