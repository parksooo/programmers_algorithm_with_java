public class CountString {
    public int solution(String s) {

        char c = s.charAt(0);
        int count = 1;
        int answer = 1;
        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                answer += 1;
                c = s.charAt(i);
            }
            if (s.charAt(i) == c) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new CountString().solution("banana"));
    }
}
