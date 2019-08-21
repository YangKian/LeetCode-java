public class n4_Median_of_Two_Sorted_Arrays {

    //解法一
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if((totalLen & 1) == 1) { //totalLen & 1 == 1 说明totalLen是奇数
            return findKthSortedArrays(nums1, nums2, (totalLen>> 1) + 1);
        } else {
            double a = findKthSortedArrays(nums1, nums2, (totalLen >> 1));
            double b = findKthSortedArrays(nums1, nums2, (totalLen >> 1) + 1);
            return (a + b) / 2;
        }

    }

    private double findKthSortedArrays(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length, len2 = nums2.length, base1 = 0, base2 = 0;
        while(true) {
            if(len1 == 0) return nums2[base2 + k - 1];
            if(len2 == 0) return nums1[base1 + k - 1];
            if(k == 1) return Math.min(nums1[base1], nums2[base2]);

            int i = Math.min(k >> 1, len1);
            int j = Math.min(k - i, len2);
            int a = nums1[base1 + i - 1], b = nums2[base2 + j - 1];

            if(i + j == k && a == b) return a;

            if(a <= b) {
                base1 += i;
                len1 -= i;
                k -= i;
            }

            if(b <= a) {
                base2 += j;
                len2 -= j;
                k -= j;
            }
        }
    }


    //解法二
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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
