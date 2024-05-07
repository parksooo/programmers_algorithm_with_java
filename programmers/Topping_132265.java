public class Topping_132265 {
    public int solution(int[] topping) {
        int answer = 0;
        int[] right = new int[10001];
        int[] left = new int[10001];

        int rightTopping = 0;
        int leftTopping = 0;

        for (int x : topping) {
            if (right[x] == 0) {
                rightTopping++;
            }
            right[x]++;
        }

        for (int x : topping) {
            if (right[x] == 1) {
                rightTopping--;
            }
            if (left[x] == 0) {
                leftTopping++;
            }
            right[x]--;
            left[x]++;

            if (rightTopping == leftTopping) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                new Topping_132265().solution(new int[]{1,2,1,3,1,4,1,2})
        );
    }
}
