import java.lang.module.ModuleReader;
import java.util.*;
public class Miro {
    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static String[][] MAP;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        MAP = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] labor = new int[2];
        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");
            for (int j = 0; j < tmp.length; j++) {
                MAP[i][j] = tmp[j];
                if (MAP[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (MAP[i][j].equals("L")) {
                    labor[0] = i;
                    labor[1] = j;
                }
            }
        }

        int farLabor = bfs(new Point(start[0], start[1], 0), "L");
        int farExit = bfs(new Point(labor[0], labor[1], 0), "E");
        if (farLabor == -1 || farExit == -1) {
            return -1;
        }
        return farLabor + farExit;
    }

    public int bfs(Point start, String target) {
        Queue<Point> q = new ArrayDeque<>();
        boolean [][] visited = new boolean[MAP.length][MAP[0].length];

        q.add(start);

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int time = p.time;
            visited[x][y] = true;

            if (MAP[x][y].equals(target)) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < MAP.length && ny >= 0 && ny < MAP[0].length && !visited[nx][ny]) {
                    if (!MAP[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, time + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Miro miro = new Miro();

        System.out.println(miro.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }
}
