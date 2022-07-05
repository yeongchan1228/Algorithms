package middleStep;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17299 { // 오등큰수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[N];
        int[] cnt = new int[1000001];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());

            arr[i] = val;
            cnt[val]++;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) arr[stack.pop()] = - 1;

        StringBuilder sb = new StringBuilder();
        for (int val : arr) sb.append(val + " ");

        System.out.println(sb);
    }
}
