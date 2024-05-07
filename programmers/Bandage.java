public class Bandage {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int rowTime = 0;
        int attackTime = 0;
        int result = health;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i != attacks[attackTime][0]) {
                result += bandage[1];
                rowTime++;
                if (rowTime == bandage[0]) {
                    result += bandage[2];
                    rowTime = 0;
                }
                if (result > health) {
                    result = health;
                }
            } else {
                rowTime = 0;
                result -= attacks[attackTime][1];
                attackTime++;
                if (result <= 0) {
                    return -1;
                }
            }
        }
        answer = result;
        return answer;
    }

    public static void main(String[] args) {
        int [] b = {3, 2, 7};
        int h = 20;
        int [][] a = {{1, 15}, {5, 16}, {8, 6}};

        Bandage bandage = new Bandage();

        System.out.println(bandage.solution(b, h, a));
    }

}
