public class n35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if(nums == null) return -1;

        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low >> 1);
            if(target > nums[mid]) low = mid + 1;
            else if(target < nums[mid]) high = mid - 1;
            else return mid;
        }
        return low; //若未查到结果，则low的下标即是该元素应该插入的位置
    }
}
