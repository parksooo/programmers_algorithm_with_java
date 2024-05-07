import java.util.Collections;
import java.util.PriorityQueue;

public class DefenceGame_142085 {
    public int solution(int n, int k, int[] enemy) {
        int soldier = n;
        int card = k;
        int answer = enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            soldier -= enemy[i];
            pq.add(enemy[i]);

            if (soldier < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    soldier += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DefenceGame_142085 defenceGame142085 = new DefenceGame_142085();

        System.out.println(defenceGame142085.solution(2, 4, new int[]{3, 3, 3, 3}));
    }
}
