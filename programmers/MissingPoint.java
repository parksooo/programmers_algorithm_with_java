import java.util.*;

public class MissingPoint {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> points = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            points.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int miss = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (points.containsKey(photo[i][j])) {
                    miss += points.get(photo[i][j]);
                }
            }
            result[i] = miss;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] year = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        MissingPoint missingPoint = new MissingPoint();

        int[] point = missingPoint.solution(name, year, photo);

        Arrays.stream(point).forEach(System.out::println);
    }
}
