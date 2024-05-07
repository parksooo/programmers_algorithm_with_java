import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnalyzeData {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        Map<String, Integer> order = new HashMap<>();

        order.put("code", 0);
        order.put("date", 1);
        order.put("maximum", 2);
        order.put("remain", 3);

        int [][] answer = Arrays.stream(data).filter(x -> x[order.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(answer, (o1, o2) -> o1[order.get(sort_by)] - o2[order.get(sort_by)]);
        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};

        AnalyzeData analyzeData = new AnalyzeData();
        int[][] a = analyzeData.solution(data, "date", 20300501, "remain");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
