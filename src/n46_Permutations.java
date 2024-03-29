import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class n46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }

        permuteRec(list, 0, result);
        return result;
    }

    private void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if(start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for(int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }
}
