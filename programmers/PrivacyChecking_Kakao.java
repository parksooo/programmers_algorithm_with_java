import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.*;
import javax.swing.text.DateFormatter;

public class PrivacyChecking_Kakao {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localToday = LocalDate.parse(today, dateFormatter);

        for (String t : terms) {
            String date = t.split(" ")[0];
            Integer p = Integer.parseInt(t.split(" ")[1]);

            map.put(date, p);
        }

        for (int i = 0; i < privacies.length; i++) {
            String d = privacies[i].split(" ")[0];
            String k = privacies[i].split(" ")[1];

            LocalDate pDay = LocalDate.parse(d, dateFormatter);
            int getDay = map.get(k);
            LocalDate a = pDay.plusMonths(getDay);

            if (localToday.isAfter(a) || localToday.isEqual(a)) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        PrivacyChecking_Kakao privacyCheckingKakao = new PrivacyChecking_Kakao();

        System.out.println(
                Arrays.toString(privacyCheckingKakao.solution("2020.01.01", new String[]{"Z 3", "D 5"},
                        new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}
