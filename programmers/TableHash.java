import java.util.Arrays;

public class TableHash {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col -= 1;
        row_begin -= 1;

        int inputCol = col;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[inputCol] == o2[inputCol])
                return o2[0] - o1[0];
            return o1[inputCol] - o2[inputCol];
        });

        for (int i = row_begin; i < row_end; i++) {
            int finalCol = i + 1;
            int dataTotal = Arrays.stream(data[i])
                    .map(remain -> remain % (finalCol))
                    .sum();
            answer = answer ^ dataTotal;
        }

        return answer;
    }

    public static void main(String[] args) {
        TableHash tableHash = new TableHash();

        System.out.println(tableHash.solution(
                new int[][]{{2,2,6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 3, 3)
        );
    }
}
