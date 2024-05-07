import java.util.Arrays;
import java.util.stream.IntStream;

public class PaintInArray {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int roller = section[0];
        for (int i = 1; i < section.length; i++) {
            if (roller + m - 1 < section[i]) {
                answer += 1;
                roller = section[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PaintInArray paintInArray = new PaintInArray();

        paintInArray.solution(5, 4, new int[] {1, 3});
    }
}
