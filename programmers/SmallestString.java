public class SmallestString {
    public int solution(String t, String p) {
        int len = p.length();
        Long pp = Long.parseLong(p);
        int a = 0;
        for (int i = 0; i < t.length() - len + 1; i++) {
            String sub = t.substring(i, i + len);
            if (Long.parseLong(sub) <= pp) {
                a += 1;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        SmallestString smallestString = new SmallestString();

        System.out.println(smallestString.solution("500220839878", "7"));
    }
}
