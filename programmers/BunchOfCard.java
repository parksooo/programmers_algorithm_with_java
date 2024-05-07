import java.util.Arrays;
import java.util.Objects;

public class BunchOfCard {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        for (String g : goal) {
            if (cards1.length > 0 && Objects.equals(cards1[0], g)) {
                cards1 = Arrays.copyOfRange(cards1, 1, cards1.length);
            } else if (cards2.length > 0 && Objects.equals(cards2[0], g)) {
                cards2 = Arrays.copyOfRange(cards2, 1,cards2.length);
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
