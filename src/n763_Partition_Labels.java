import java.util.ArrayList;
import java.util.List;

public class n763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int[] temp = new int[26];
        for(int i = 0; i < S.length(); ++i) {
            temp[S.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for(int j = 0; j <S.length(); ++j) {
            end = Math.max(end, temp[S.charAt(j) - 'a']);
            System.out.println("s: " + S.charAt(j) + " end: " + end + " j: " + j);
            if(end == j) {
                System.out.println("ADD __________________");
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        n763_Partition_Labels qua = new n763_Partition_Labels();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = qua.partitionLabels(s);
    }
}
