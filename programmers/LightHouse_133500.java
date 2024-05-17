import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightHouse_133500 {
    List<List<Integer>> graph;
    boolean[] visited;
    int[][] dp;

    public int solution(int n, int[][] lighthouse) {
        int answer = n;
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] light : lighthouse) {
            graph.get(light[0]).add(light[1]);
            graph.get(light[1]).add(light[0]);
        }

        dfs(1);
        answer = Math.min(dp[1][0], dp[1][1]);

        return answer;
    }

    private void dfs(int x) {
        visited[x] = true;

        dp[x][1] = 1;

        for (int i : graph.get(x)) {
            if (!visited[i]) {
                dfs(i);

                dp[x][0] += dp[i][1];
                dp[x][1] += Math.min(dp[i][0], dp[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new LightHouse_133500().solution(10, new int[][]{{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 1}})
        );
    }
}
