package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem13414 { // 수강 신청
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new LinkedHashSet<>();
        while (m --> 0) {
            String studentId = in.readLine();
            if (hashSet.contains(studentId)) {
                hashSet.remove(studentId);
            }
            hashSet.add(studentId);
        }

        String result = hashSet.stream().limit(n).collect(Collectors.joining("\n"));

        out.write(result);
        out.flush();
        out.close();
    }
}
