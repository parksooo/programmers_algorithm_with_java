import java.util.*;
public class Siso {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            map.put(i * 2, map.getOrDefault(i * 2, 0) + 1);
            map.put(i * 3, map.getOrDefault(i * 3, 0) + 1);
            map.put(i * 4, map.getOrDefault(i * 4, 0) + 1);
        }
        Collection<Integer> values = map.values();
        System.out.println(values);
        return answer;
    }

    public static void main(String[] args) {
        Siso siso = new Siso();

        System.out.println(siso.solution(new int[]{100, 180, 360, 270, 100}));
    }

}
