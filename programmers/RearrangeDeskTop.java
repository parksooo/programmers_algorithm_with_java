import java.util.Arrays;
import java.util.Objects;

public class RearrangeDeskTop {
    public int [] solution(String [] wallpaper) {
        int lux = 0, luy = 0, rdx = 0, rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = i;
                break;
            }
        }

        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                rdx = i + 1;
                break;
            }
        }

        for (int j = 0; j < wallpaper[0].length(); j++) {
            int flag = 0;
            for (int i = 0; i < wallpaper.length; i++) {
                if (Objects.equals(wallpaper[i].charAt(j), '#')) {
                    luy = j;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }

        for (int j = wallpaper[0].length() - 1; j >= 0; j--) {
            int flag = 0;
            for (int i = wallpaper.length - 1; i >= 0; i--) {
                if (Objects.equals(wallpaper[i].charAt(j), '#')) {
                    rdy = j + 1;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }

        return new int[] {lux, luy, rdx, rdy};
    }

    public static void main(String[] args) {
        RearrangeDeskTop rearrangeDeskTop = new RearrangeDeskTop();

        System.out.println(Arrays.toString(rearrangeDeskTop.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
    }
}
