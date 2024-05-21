import java.util.Arrays;

public class BestChoiceArcheology_131702 {
    int N = Integer.MAX_VALUE;
    int answer = Integer.MAX_VALUE;
    int[][] clockStatus;
    int[] rotation;
    int[] dx = {0, 0, 0, 1, -1};
    int[] dy = {0, 1, -1, 0, 0};

    public int solution(int[][] clockHands) {
        N = clockHands.length;
        clockStatus = new int[N][N];
        rotation = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                clockStatus[i][j] = 4 - clockHands[i][j] == 4 ? 0 : 4 - clockHands[i][j];
            }
        }
        dfs(0);
        return answer;
    }

    private void dfs(int depth) {
        if (depth == N) {
            int[][] tmp = new int[N][N];
            int[] currRotation = new int[N];

            updateStatus(tmp, currRotation);

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count += currRotation[j];
                    for (int k = 0; k < 5; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x < 0 || y < 0 || x >= N || y >= N) {
                            continue;
                        }
                        tmp[x][y] = tmp[x][y] - currRotation[j] >= 0 ? tmp[x][y] - currRotation[j] : tmp[x][y] - currRotation[j] + 4;
                    }
                }
                for (int j = 0; j < N; j++) {
                    currRotation[j] = tmp[i][j];
                }
            }

            boolean flag = true;

            for (int i = 0; i < N; i++) {
                if (currRotation[i] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer = Math.min(answer, count);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            rotation[depth] = i;
            dfs(depth + 1);
        }
    }

    private void updateStatus(int[][] tmp, int[] currRotation) {
        for (int i = 0; i < N; i++) {
            currRotation[i] = rotation[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = clockStatus[i][j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new BestChoiceArcheology_131702().solution(
                        new int[][]{{0, 3, 3, 0}, {3, 2, 2, 3}, {0, 3, 2, 0}, {0, 3, 3, 3}}
                )
        );
    }
}
