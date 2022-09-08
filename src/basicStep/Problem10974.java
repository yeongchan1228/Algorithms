package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by YC on 2022/09/08.
 */
public class Problem10974 { // 모든 순열
    static int n;
    static int[] saveNums;
    static boolean[] isSelected;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        saveNums = new int[n];
        isSelected = new boolean[n];

        calc(0);

        System.out.println(result.toString());
    }

    static void calc(int depth) {
        if (depth == n) {
            for (int i = 0; i < saveNums.length; i++) {
                result.append(saveNums[i] + " ");
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                saveNums[depth] = i + 1;
                isSelected[i] = true;
                calc(depth + 1);
                isSelected[i] = false;
            }
        }
    }
}
