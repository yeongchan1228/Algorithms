package middleStep;

import java.io.*;
import java.util.*;

public class Problem14003 { // 가장 긴 증가하는 부분 수열 5
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] save = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;

            if(list.size() == 0) {
                list.add(value);
                save[i] = list.size() - 1;
            }
            else if(list.get(list.size() - 1) < value) {
                list.add(value);
                save[i] = list.size() - 1;
            }
            else {
                int left = 0;
                int right = list.size() - 1;

                while (left < right){
                    int mid = (left + right) / 2;

                    if(list.get(mid) < value) left = mid + 1;
                    else right = mid;
                }

                list.set(right, value);
                save[i] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");

        Stack<Integer> stack = new Stack<>();

        int check = list.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if(save[i] == check){
                stack.add(arr[i]);
                check--;
            }
        }

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            sb.append(pop + " ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();

    }
}
