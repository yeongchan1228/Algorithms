package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11729 { // 하노이 탑

    static int result = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        calc(N, 1, 2, 3);
        sb.insert(0, result + "\n");

        System.out.println(sb);
    }

    static void calc(int size, int from, int mid, int to){
        result++;
        if(size == 1){
            sb.append(from + " " + to).append('\n');
        }else{
            calc(size - 1, from, to, mid);
            sb.append(from + " " + to).append('\n');

            calc(size - 1, mid, from, to);
        }
    }
}
