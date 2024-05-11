import java.util.Arrays;

public class Capet_42842 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    return new int[]{j, i};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Capet_42842().solution(24, 24)
                )
        );
    }
}
