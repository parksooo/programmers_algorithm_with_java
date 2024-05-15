import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HundredMillion_138475 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e + 1];
        int[][] store = new int[e + 1][2];
        count[0] = -1;

        getDivisor(count, e);
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

    private void getDivisor(int[] n, int e) {
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= (e / i); j++) {
                n[i * j] += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new HundredMillion_138475().solution(8, new int[]{1, 3, 7});
        System.out.println(Arrays.toString(arr));
    }
}
// 1 4
// 1 : 1, 2: 2 3, 3: 4