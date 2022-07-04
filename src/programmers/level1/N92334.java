package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class N92334 { // 신고 결과 받기
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String from = split[0];
            String to = split[1];

            if(!reportMap.containsKey(to)) {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(from);
                reportMap.put(to, hashSet);
            } else {
                reportMap.get(to).add(from);
            }
        }

        HashMap<String, Integer> mailMap = new HashMap<>();
        for (String reportedId : reportMap.keySet()) {
            HashSet<String> reporters = reportMap.get(reportedId);
            if(reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailMap.put(reporter, mailMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if(mailMap.containsKey(id_list[i])) {
                answer[i] = mailMap.get(id_list[i]);
            }
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }
}
