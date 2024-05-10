public class MakeBigCount_42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            System.out.println(max);
            answer.append(max);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new MakeBigCount_42883().solution("4177252841", 4)
        );
    }
}
