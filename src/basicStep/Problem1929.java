package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929 { // 소수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        // 시간 초과
//        boolean check = true;
//        for (long i = M; i <= N; i++) {
//            for (int j = 2; j < i; j++) {
//                if(i % j == 0) {
//                    check = false;
//                    break;
//                }
//            }
//
//            if(check){
//                System.out.println(i);
//            }else{
//                check = true;
//            }
//        }

        // 2. 에라스테네스의 체
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] arr = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;

        int sqrt = (int) Math.sqrt(N);

        for (int i = 2; i <= sqrt; i++) {
            if(arr[i]) {
                continue;
            }

            for (int j = (int) Math.pow(i, 2); j <= N; j += i) {
                arr[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!arr[i])
                stringBuilder.append(i).append('\n');
        }

        System.out.println(stringBuilder);

    }
}
