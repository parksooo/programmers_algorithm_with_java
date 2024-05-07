import java.util.HashMap;

public class PhoneKeyBoard {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>();

        for (String k : keymap) {
            for (int i = 0; i < k.length(); i++) {
                map.put(k.charAt(i), Math.min(i + 1, map.getOrDefault(k.charAt(i), Integer.MAX_VALUE)));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String s = targets[i];

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (map.containsKey(c)) {
                    answer[i] += map.get(c);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        for(int a : answer) {
            System.out.println(a + " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneKeyBoard phoneKeyBoard = new PhoneKeyBoard();

        phoneKeyBoard.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
    }
}
