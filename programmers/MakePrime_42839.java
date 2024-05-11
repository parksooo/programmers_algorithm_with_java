import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class MakePrime_42839 {
    final Set<Integer> SET = new HashSet<>();
    boolean[] VISITED = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        dfs(numbers, "", 0);
        for (Integer num : SET) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(String n, String str, int len) {
        if (len > n.length()) {
            return;
        }

        for (int i = 0; i < n.length(); i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                SET.add(Integer.parseInt(str + n.charAt(i)));
                dfs(n, str + n.charAt(i), len + 1);
                VISITED[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                new MakePrime_42839().solution("011")
        );
    }
}
