import java.util.HashMap;

public class MostGiftedPresent {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        int[] friendDegree = new int [friendsLength];
        int[][] graph = new int[friendsLength][friendsLength];
        HashMap<String, Integer> dic = new HashMap<>();

        for (int i = 0; i < friendsLength; i++) {
            dic.put(friends[i], i);
        }

        for (String g : gifts) {
            String [] list = g.split(" ");
            friendDegree[dic.get(list[0])]++;
            friendDegree[dic.get(list[1])]--;
            graph[dic.get(list[0])][dic.get(list[1])]++;
        }

        for (int i = 0; i < friendsLength; i++) {
            int num = 0;
            for (int j = 0; j < friendsLength; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] > graph[j][i] || (graph[i][j] == graph[j][i] && friendDegree[i] > friendDegree[j])) {
                    num++;
                }
            }
            if (answer < num) {
                answer = num;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MostGiftedPresent m = new MostGiftedPresent();
        String[] f = {"muzi", "ryan", "frodo", "neo"};
        String[] g = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(m.solution(f, g));
    }
}
