import java.util.Collections;
import java.util.PriorityQueue;

public class Process_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int value : priorities) {
            q.add(value);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    q.poll();
                    answer++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Process_42587().solution(new int[]{1, 1, 9, 1, 1, 1}, 0)
        );
    }
}
