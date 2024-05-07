import java.util.Collections;
import java.util.HashMap;

public class NeighborHood {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int len = board[0].length;
        for (String[] b : board) {
            for (int i = 0; i < len; i++) {
                map.put(b[i], 0);
            }
        }

        if (h - 1 >= 0) {
            map.put(board[h - 1][w], map.get(board[h - 1][w]) + 1);
        }
        if (h + 1 < len) {
            map.put(board[h + 1][w], map.get(board[h + 1][w]) + 1);
        }
        if (w - 1 >= 0) {
            map.put(board[h][w - 1], map.get(board[h][w - 1]) + 1);
        }
        if (w + 1 < len) {
            map.put(board[h][w + 1], map.get(board[h][w + 1]) + 1);
        }

        answer = map.get(board[h][w]);
        return answer;
    }

    public static void main(String[] args) {
        String[][] a = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};

        NeighborHood n = new NeighborHood();

        System.out.println(n.solution(a, 1, 1));
    }
}
