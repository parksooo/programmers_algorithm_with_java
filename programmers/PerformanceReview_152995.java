import java.util.Arrays;

public class PerformanceReview_152995 {
    public int solution(int[][] scores) {
        int[] wanho = new int[2];
        int rank = 1;
        wanho[0] = scores[0][0];
        wanho[1] = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        int max = scores[0][1];

        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < max) {
                if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
                    return -1;
                }

                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                max = scores[i][1];
            }
        }

        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));

        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
                break ;
            }
            rank++;
        }


        return rank;
    }
}
