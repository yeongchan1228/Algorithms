package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.StringTokenizer;

public class Problem1546 { // 평균
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(stringTokenizer.nextToken());
        }

        OptionalDouble max = Arrays.stream(arr).max();

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i]/ max.getAsDouble() * 100;
        }

        double result =(Arrays.stream(arr).sum()) / (double) N;

        System.out.println(result);
    }
}
