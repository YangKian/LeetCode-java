import java.util.HashSet;
import java.util.Set;

public class n136_Single_Number {
    //方法一：位运算
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

    //方法二：使用集合
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, setSum = 0;
        for(int i : nums) {
            sum += i;
            if (!set.contains(i)) {
                set.add(i);
                setSum += i;
            }
        }
        return 2 * setSum - sum;
    }
}
