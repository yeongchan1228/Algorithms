package basicStep;

import java.io.*;
import java.util.*;

public class Problem12015 { // 가장 긴 증가하는 부분 수열2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        list.add(0);

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(list.get(list.size() - 1) < value){
                list.add(value);
            }else{
                int left = 1;
                int right = list.size() - 1;

                while (left < right){
                    int mid = (right + left) / 2;
                    if(list.get(mid) < value){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                list.set(right, value);
            }
        }

        out.write(String.valueOf(list.size() - 1));
        out.flush();
        in.close();
        out.close();
    }
}
