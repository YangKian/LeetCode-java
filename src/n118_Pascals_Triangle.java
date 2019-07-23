import java.util.ArrayList;
import java.util.List;

public class n118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if(numRows == 0) return result;

        for(int i = 0; i < numRows; ++i) {
            List<Integer> inner = new ArrayList<>(i + 1);
            for(int j = 0; j < i + 1; ++j) {
                if(j == 0 || j == i) {
                    inner.add(1);
                    continue;
                }
                inner.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            result.add(inner);
        }
        return result;
    }
}