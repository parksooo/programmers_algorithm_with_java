import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HundredMillion_138475 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e + 1];
        int[][] store = new int[e + 1][2];
        count[0] = -1;

        for (int i = 1; i <= e; i++) {
            count[i] = getDivisor(i);
        }
        store[e][0] = count[e];
        store[e][1] = e;

        storeDivisor(count, store, e);

        for (int i = 0; i < starts.length; i++) {
            answer[i] = store[starts[i]][1];
        }

        return answer;
    }

    private void storeDivisor(int[] divisor, int[][] store, int e) {
        for (int i = e - 1; i >= 1; i--) {
            if (divisor[i] >= store[i + 1][0]) {
                store[i][0] = divisor[i];
                store[i][1] = i;
            } else {
                store[i][0] = store[i + 1][0];
                store[i][1] = store[i + 1][1];
            }
        }
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