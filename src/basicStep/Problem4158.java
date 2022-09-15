package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/15.
 */
public class Problem4158 {
    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int sameVal = 0;
            HashSet<Integer> cds = new HashSet<>();
            while (n-- > 0) {
                cds.add(Integer.parseInt(in.readLine()));
            }

            while (m-- > 0) {
                if (cds.contains(Integer.parseInt(in.readLine()))) {
                    sameVal++;
                }
            }

            result.append(sameVal + "\n");
        }

        System.out.println(result.toString());

    }
}