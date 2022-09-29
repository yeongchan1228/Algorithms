import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem7785 { // 회사에 있는 사람

    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();

            if (st.nextToken().equals("enter")) {
                hashSet.add(name);
            } else {
                hashSet.remove(name);
            }
        }

        StringBuilder result = new StringBuilder();
        hashSet.stream().sorted((o1, o2) -> o2.compareTo(o1)).forEach(key -> result.append(key + "\n"));

        out.write(result.toString());
        out.flush();
        out.close();
    }

}
