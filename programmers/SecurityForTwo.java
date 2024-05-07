import java.util.Arrays;

public class SecurityForTwo {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 1; j <= index; j++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    j -= 1;
                }
            }
            answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
        SecurityForTwo securityForTwo = new SecurityForTwo();

        System.out.println(securityForTwo.solution("aukks", "wbqd", 5));
    }
}
