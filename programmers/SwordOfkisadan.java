public class SwordOfkisadan {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int v = getDivisor(i);
            System.out.println(v);
            if (v > limit) {
                answer += power;
            } else {
                answer += v;
            }
        }
        return answer;
    }

    public static int getDivisor(int n) {
        int cnt = 0;
        for (int i = 1; i * i <=n; i++) {
            if (i * i == n) {
                cnt += 1;
            } else if (n % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SwordOfkisadan swordOfkisadan = new SwordOfkisadan();

        System.out.println(swordOfkisadan.solution(5, 3, 2));
    }
}
