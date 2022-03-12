package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 { // ATM
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] time = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
            time[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(time);

        int save = 0;
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            save += time[i];
            result += save;
        }

        System.out.println(result);
    }
}
