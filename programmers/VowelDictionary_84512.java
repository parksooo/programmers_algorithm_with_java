import java.util.ArrayList;
import java.util.List;

public class VowelDictionary_84512 {
    static List<String> list;
    final static String[] VOWEL = {"A", "E", "I", "O", "U"};
    final static int MAX_LENGTH = 5;

    public int solution(String word) {
        list = new ArrayList<>();
        dfs("", 0);

        return list.indexOf(word);
    }

    public void dfs(String str, int len) {
        list.add(str);
        if (len == MAX_LENGTH) {
            return ;
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            dfs(str + VOWEL[i], len + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new VowelDictionary_84512().solution("I")
        );
    }
}
