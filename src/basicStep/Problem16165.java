package basicStep;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem16165 { // 걸그룹 마스터 준석이
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, HashSet<String>> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n --> 0) {
            String teamName = in.readLine();
            int cnt = Integer.parseInt(in.readLine());

            HashSet<String> members = new HashSet<>();
            while (cnt --> 0) {
                members.add(in.readLine());
            }

            hashMap.put(teamName, members);
        }

        StringBuilder result = new StringBuilder();
        while (m --> 0) {
            String q = in.readLine();
            int num = Integer.parseInt(in.readLine());

            if (num == 0) {
                HashSet<String> members = hashMap.get(q);
                members.stream().sorted().forEach(member -> result.append(member + "\n"));
            } else {
                for (String team : hashMap.keySet()) {
                    HashSet<String> members = hashMap.get(team);
                    if (members.contains(q)) {
                        result.append(team + "\n");
                        break;
                    }
                }
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
