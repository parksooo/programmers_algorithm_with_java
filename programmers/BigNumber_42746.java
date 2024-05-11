import java.util.Arrays;

public class BigNumber_42746 {
    public String solution(int[] numbers) {
        String[] str = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (str[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(str)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }


    public static void main(String[] args) {
        System.out.println(
                new BigNumber_42746().solution(new int[]{3, 30, 34, 5, 9})
        );
    }
}
