import java.util.HashMap;
import java.util.Map;

public class n167_Two_Sum_II_Input_array_is_sorted {
    //解法一：哈希表
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < numbers.length; ++i) {
            int v = target - numbers[i];
            if(map.containsKey(v)) {
                result[0] = map.get(v) + 1;
                result[1] = i + 1;
            } else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }

    //解法二：双指针
    public int[] twoSum1(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while(i < j) {
            int sum = numbers[i] + numbers[j];

            if(sum < target) {
                while(i++ < j && numbers[i] == numbers[i - 1]) {};
            } else if (sum > target) {
                while(i < j-- && numbers[j] == numbers[j + 1]) {};
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{0, 0};
    }
}
