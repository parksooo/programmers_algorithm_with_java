import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MakeHotter_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        Queue<Integer> q = new PriorityQueue<>();

        for (int value : scoville) {
            q.add(value);
        }

        while(!q.isEmpty()) {
            if (q.peek() < K) {
                if (q.size() < 2) {
                    return -1;
                }
                int a = q.poll();
                int b = q.poll();

                int newScovile = a + 2*b;
                answer++;
                q.add(newScovile);
            } else {
                break ;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                new MakeHotter_42626().solution(new int[]{1, 2, 3, 9, 10, 12}, 7)
        );
    }
}
