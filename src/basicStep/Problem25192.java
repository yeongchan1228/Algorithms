package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by YC on 2022/09/11.
 */
public class Problem25192 { // 인사성 밝은 곰곰이
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int n = Integer.parseInt(in.readLine());
        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = in.readLine();
            if (name.equals("ENTER")) {
                result += names.size();
                names.clear();
            } else {
                names.add(name);
            }
        }

        System.out.println(result + names.size());
    }
}
