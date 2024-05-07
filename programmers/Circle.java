public class Circle {
    public long solution(int r1, int r2) {
        long r2Cnt = (long) r2 * r2;
        long r1Cnt = (long) r1 * r1;
//        System.out.println(r2Cnt + r1Cnt);
        return (r2Cnt - r1Cnt) * 4 ;/**/
    }

    public static void main(String[] args) {
        System.out.println(new Circle().solution(2, 3));
    }
}
