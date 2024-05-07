import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RunningCalling {
    public String[] solution(String[] players, String[] callings) {
        for (String name : callings) {
            for (int i = 0; i < players.length; i++) {
                if (Objects.equals(players[i], name)) {
                    String tmp = players[i - 1];
                    players[i - 1] = name;
                    players[i] = tmp;
                }
            }
        }
        return players;
    }

    public String[] solution2(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String name : callings) {
            int playerRank = rank.get(name);

            String inFront = players[playerRank - 1];
            rank.replace(inFront, playerRank);
            players[playerRank] = inFront;

            rank.replace(name, playerRank - 1);
            players[playerRank - 1] = name;
        }

        return players;
    }


    public static void main(String[] args) {
        RunningCalling r = new RunningCalling();
        String [] p = {"mumu", "soe", "poe", "kai", "mine"};
        String [] c = {"kai", "kai", "mine", "mine"};
        String [] result = r.solution2(p, c);

        Arrays.stream(result).forEach(System.out::println);
    }
}
