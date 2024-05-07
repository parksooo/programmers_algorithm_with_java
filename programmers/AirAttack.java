import java.util.*;

public class AirAttack {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int val = -1;
        for (int [] target : targets) {
            if (target[0] < val) {
                continue;
            }
            answer += 1;
            val = target[1];
        }
        return answer;

    }

    public static void main(String[] args) {
        AirAttack airAttack = new AirAttack();

        System.out.println(airAttack.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }
}
