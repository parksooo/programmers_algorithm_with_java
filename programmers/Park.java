import java.util.*;
public class Park {
    public int[] solution(String[] park, String[] routes) {
        int map[][] = new int[park.length][park[0].length()];
        int posX = 0;
        int posY = 0;
        for (int i = 0; i < park.length; i++) {
            char [] low = park[i].toCharArray();
            for (int j = 0; j < low.length; j++) {
                if (Objects.equals(low[j], 'O')) {
                    map[i][j] = 0;
                }
                else if (Objects.equals(low[j], 'X')) {
                    map[i][j] = 1;
                }
                else if (Objects.equals(low[j], 'S')) {
                    posX = j;
                    posY = i;
                }
            }
            System.out.println(map[i][0] + "" + map[i][1] + "" + map[i][2] + "");
        }

        for (String r : routes) {
            String w = r.split(" ")[0];
            int len = Integer.parseInt(r.split(" ")[1]);
            int x = posX;
            int y = posY;
            System.out.println("B :" + x + " " + y);
            for (int i = 0; i < len; i ++) {
                if (Objects.equals(w, "E")) {
                    x += 1;
                }
                if (Objects.equals(w, "W")) {
                    x -= 1;
                }
                if (Objects.equals(w, "S")) {
                    y += 1;
                }
                if (Objects.equals(w, "N")) {
                    y -= 1;
                }
                if (x >= 0 && y >= 0 && x < map[0].length && y < map.length) {
                    if (map[y][x] == 1)
                        break;
                }
                else
                    break ;

                if (i == len - 1) {
                    posX = x;
                    posY = y;
                }
//                System.out.println(posX + " " + posY);
            }
        }
        return new int[] {posY, posX};
    }

    public static void main(String[] args) {
        String [] park = {"OSO", "OOO", "OXO", "OOO"};
        String [] routes = {"E 2", "S 3", "W 1"};

        int [] result = new Park().solution(park, routes);

        System.out.println(result[0] + " " + result[1]);
    }
}
