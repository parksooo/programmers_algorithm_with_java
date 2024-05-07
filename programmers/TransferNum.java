import java.util.*;
public class TransferNum {
    //    public int solution(int x, int y, int n) {
    //        int[] answer = new int[]{-1, -1, -1};
//        int tmp = x;
//        int index = 0;
//        while (tmp < y) {
//            tmp += n;
//
//            if (tmp == y) {
//                answer[0] = index + 1;
//                break ;
//            }
//            index += 1;
//        }
//        tmp = x;
//        index = 0;
//        while (tmp < y) {
//            tmp *= 2;
//
//            if (tmp == y) {
//                answer[1] = index + 1;
//                break ;
//            }
//            index += 1;
//        }
//
//        tmp = x;
//        index = 0;
//        while (tmp < y) {
//            tmp *= 3;
//
//            if (tmp == y) {
//                answer[2] = index + 1;
//                break;
//            }
//            index += 1;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            if (answer[i] != -1) {
//                min = Math.min(min, answer[i]);
//            }
//        }
//        return min != Integer.MAX_VALUE ? min : -1;
//    }
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, y + 1);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == y + 1) continue;
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        return dp[y];
    }
    public static void main(String[] args) {
        TransferNum transferNum = new TransferNum();

        System.out.println(transferNum.solution(10, 40, 5));
    }
}
