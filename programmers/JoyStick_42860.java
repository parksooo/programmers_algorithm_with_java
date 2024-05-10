public class JoyStick_42860 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        int index;
        if ("".equals(name.replace("A", ""))) {
            return 0;
        }
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += Math.min(name.charAt(i) - 65, 91 - name.charAt(i));
                index = i + 1;
                while (index < name.length() && name.charAt(index) == 'A')
                    index++;
                move = Math.min(move, i * 2 + name.length() - index);
                move = Math.min(move, (name.length() - index) * 2 + i);
            }
        }

        return answer + move;
    }


    public static void main(String[] args) {
        System.out.println(
                new JoyStick_42860().solution("JJ")
        );
    }
}
