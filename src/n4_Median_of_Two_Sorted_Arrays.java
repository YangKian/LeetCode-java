public class n4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int size1 = nums1.length;
        final int size2 = nums2.length;

        if(size1 > size2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (size1 + size2 + 1) >> 1;
        int left = 0;
        int right = size1;


        while(left < right) {
            int m1 = left + (right - left >> 1);
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                left = m1 + 1;
            } else {
                right = m1;
            }
        }

        int m1 = left;
        int m2 = k - left;

        int left_res = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if((size1 + size2) % 2 == 1) {
            return left_res;
        }

        int right_res = Math.min(m1 >= size1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= size2 ? Integer.MAX_VALUE : nums2[m2]);

        return (left_res + right_res) * 0.5;

    }

    public static void main(String[] args) {
        n4_Median_of_Two_Sorted_Arrays res = new n4_Median_of_Two_Sorted_Arrays();
        int[] nums1 = {-1,1,3,5,7,9};
        int[] nums2 = {2,4,6,8,10,12,14,16};
        System.out.println(res.findMedianSortedArrays(nums1, nums2));
    }
}
