import java.util.LinkedList;
import java.util.Queue;

public class Wire_86971 {
    static int[][] wireArray;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        wireArray = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            // 인접 행렬을 만들기
            wireArray[wires[i][0]][wires[i][1]] = 1;
            wireArray[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            wireArray[left][right] = 0;
            wireArray[right][left] = 0;

            answer = Math.min(answer, bfs(left, n));

            wireArray[left][right] = 1;
            wireArray[right][left] = 1;
        }
        return answer;
    }

    public int  bfs(int left, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(left);

        while (!q.isEmpty()) {
            int tmp = q.poll();
            visited[tmp] = true;
            for (int i = 1; i < n + 1; i++) {
                if (wireArray[tmp][i] == 1 && !visited[i]) {
                    q.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs(cnt - (n - cnt));
    }

    public static void main(String[] args) {
        System.out.println(
                new Wire_86971().solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})
        );
    }
}
