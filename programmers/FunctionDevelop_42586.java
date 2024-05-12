import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class FunctionDevelop_42586 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while (!q.isEmpty()) {
            int minDay = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= minDay) {
                q.poll();
                count++;
            }
            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                new FunctionDevelop_42586().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})
        );
    }
}
