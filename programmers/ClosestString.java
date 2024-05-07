import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class ClosestString {
    public List<Integer> solution(String s) {
        StringBuffer sb = new StringBuffer(s);

        String rev = sb.reverse().toString();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < rev.length(); i++) {
            int flag = 0;
            char c = rev.charAt(i);
            for (int j = i + 1; j < rev.length(); j++) {
                if (c == rev.charAt(j)) {
                    stack.push(j - i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                stack.push(-1);
            }

        }

        List<Integer> i = new ArrayList<>();
        while (!stack.empty()) {
            i.add(stack.pop());
        }
        return i;
    }

    public static void main(String[] args) {
        ClosestString closestString = new ClosestString();

        List<Integer> a = closestString.solution("foobar");

        a.forEach(System.out::println);
    }
}
