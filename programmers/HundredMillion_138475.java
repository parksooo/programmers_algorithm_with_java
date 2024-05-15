import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.lang.model.type.ArrayType;

public class HundredMillion_138475 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e + 1];
        count[0] = -1;

        for (int i = 1; i <= e; i++) {
            count[i] = getDivisor(i);
        }

        for (int i = 0; i < starts.length; i++) {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = starts[i]; j <= e; j++) {
                if (maxValue < count[j]) {
                    maxIndex = j;
                    maxValue = count[j];
                }
            }
            answer[i] = maxIndex;
        }

        return answer;
    }

    private int getDivisor(int n) {
        int sqrt = (int)Math.sqrt(n);
        List<Integer> divisorList = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                divisorList.add(i);
                if (n / i != i) {
                    divisorList.add(i);
                }
            }
        }
        return divisorList.size();
    }

    public static void main(String[] args) {
        int[] arr = new HundredMillion_138475().solution(8, new int[]{1, 3, 7});
        System.out.println(Arrays.toString(arr));
    }
}
// 1 4
// 1 : 1, 2: 2 3, 3: 4