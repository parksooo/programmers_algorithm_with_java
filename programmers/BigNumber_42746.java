import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BigNumber_42746 {
    Set<Long> SET = new HashSet<>();
    boolean[] VISITED;
    public String solution(int[] numbers) {
        VISITED = new boolean[numbers.length];
        Long max = Long.MIN_VALUE;

        dfs(Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new),
                "",
                0);

        for (Long n : SET) {
            max = Math.max(max, n);
        }

        return String.valueOf(max);
    }

    public void dfs(String[] nums, String str, int len) {
        for (int i = 0; i < nums.length; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                SET.add(Long.parseLong(str + nums[i]));
                dfs(nums, str + nums[i], len + 1);
                VISITED[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new BigNumber_42746().solution(new int[]{3, 30, 34, 5, 9})
        );
    }
}
