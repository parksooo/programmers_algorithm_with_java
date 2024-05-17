import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberTypingContest_136797 {
    // dp + bfs을 사용해서 푸는 문제
    // dp에 메모를 해둔다.
    // 1. dp[누를 숫자의 인덱스][왼쪽 손가락의 위치][오른쪽 손가락의 위치] = 가중치
    // 2. 이 가중치들을 비교해서 최적을 찾아내는 방식
    // 2 - 1. 점화식 dp[n][left][right] = min(w[left][n] + dp[n+1][n][right], w[right][n] + dp[n+1][left][n])
    // 3. bfs를 통해 갈수 있는 곳을 정하면서, 가중치 확인 및 방문 확인

    int[][][] dp;
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] diagonal = {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    int[][] w;
    int[] num;
    char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};
    int n;

    public int solution(String numbers) {
        n = numbers.length();
        num = new int[n];
        dp = new int[n][10][10];
        w = new int[10][10];

        initialArray(numbers);

        return getMinTime(0, 4, 6);
    }

    private void initialArray(String numbers) {
        for (int i = 0; i < n; i++) {
            num[i] = numbers.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                w[i][j] = 100;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '*' && board[i][j] != '#') {
                    bfs(i, j, board[i][j] - '0');
                }
            }
        }
    }

    private int getMinTime(int index, int left, int right) {
        if (index == n) {
            return 0;
        }

        if (dp[index][left][right] == Integer.MAX_VALUE) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            // 눌러야 할 숫자에 오른쪽 손가락이 위치해있다면 왼쪽 손가락으로 누를 수 없음
            if (right != num[index]) {
                first = w[left][num[index]] + getMinTime(index + 1, num[index], right);
            }
            // 눌러야 할 숫자에 왼쪽 손가락이 위치해있다면 오른쪽 손가락으로 누를 수 없음
            if (left != num[index]) {
                second = w[right][num[index]] + getMinTime(index + 1, left, num[index]);
            }
            dp[index][left][right] = Math.min(first, second);
        }
        return dp[index][left][right];
    }

    private void bfs(int row, int col, int num) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col, num, 0});

        w[num][num] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            //동서남북 이동 후 확인
            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + move[i][0];
                int nextCol = now[1] + move[i][1];

                if (checkRange(nextRow, nextCol) && board[nextRow][nextCol] != '*'
                        && board[nextRow][nextCol] != '#' && w[num][board[nextRow][nextCol] - '0'] > now[3] + 2) {
                    w[num][board[nextRow][nextCol] - '0'] = now[3] + 2;
                    w[board[nextRow][nextCol] - '0'][num] = now[3] + 2;
                    q.offer(new int[]{nextRow, nextCol, board[nextRow][nextCol] - '0', now[3] + 2});
                }
            }

            //대각선 이동 후 확인
            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + diagonal[i][0];
                int nextCol = now[1] + diagonal[i][1];

                if (checkRange(nextRow, nextCol) && board[nextRow][nextCol] != '*'
                        && board[nextRow][nextCol] != '#' && w[num][board[nextRow][nextCol] - '0'] > now[3] + 3) {
                    w[num][board[nextRow][nextCol] - '0'] = now[3] + 3;
                    w[board[nextRow][nextCol] - '0'][num] = now[3] + 3;
                    q.offer(new int[]{nextRow, nextCol, board[nextRow][nextCol] - '0', now[3] + 3});
                }
            }
        }
    }

    private boolean checkRange(int row, int col) {
        return row >= 0 && row < 4 && col >= 0 && col < 3;
    }

    public static void main(String[] args) {
        System.out.println(
                new NumberTypingContest_136797().solution("5123")
        );
    }
}
