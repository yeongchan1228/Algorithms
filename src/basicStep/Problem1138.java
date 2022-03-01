package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1138 { // 한 줄로 서기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = N; i >= 1; i--){
            arrayList.add(arr[i-1], i);
        }

        arrayList.forEach(item -> System.out.print(item + " "));

    }
}
