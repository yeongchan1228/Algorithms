package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem11723 { // 집합
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        int n = Integer.parseInt(in.readLine());
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(st.nextToken()))) {
                        result.append(1 + "\n");
                    } else {
                        result.append(0 + "\n");
                    }
                    break;
                case "toggle":
                    int val = Integer.parseInt(st.nextToken());
                    if (set.contains(val)) {
                        set.remove(val);
                    } else {
                        set.add(val);
                    }
                    break;
                case "all":
                    if (set.size() > 0) {
                        set.clear();
                    }
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
