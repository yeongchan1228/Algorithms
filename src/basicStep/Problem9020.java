package basicStep;

import java.io.*;

public class Problem9020 { // 골드바흐의 추측

    static boolean[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];

        int max = -1;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(in.readLine());
            if(value > max) {
                max = value;
            }
            arr[i] = value;
        }

        nums = new boolean[max+1];
        calc(max); // 소수 구하기

        int minus = Integer.MAX_VALUE;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            int num1 = number/2;
            int num2 = number/2;

            while (true) {
                if (!nums[num1] && !nums[num2]) {
                    stringBuilder.append(num1 + " " + num2).append('\n');
                    break;
                }
                num1--;
                num2++;
            }

//            boolean check = false;
//            for (int j = setNum; j > 1; j--) {
//                if(!nums[j]){
//                    for (int k = setNum; k <= number; k++) {
//                        if(!nums[k]){
//                            if(j + k == number){
//                                stringBuilder.append(j + " " + k).append('\n');
//                                check = true;
//                                break;
//                            }
//                        }
//                    }
//                    if(check)
//                        break;;
//                }
//            }

            out.write(stringBuilder.toString());
            out.flush();
            stringBuilder.setLength(0);
        }

        out.close();
    }

    static void calc(int max){
        nums[0] = nums[1] = true;
        for(int i = 2; i <= Math.sqrt(max); i++){
            if(!nums[i]){
                for (int j = i * i; j <= max; j += i) {
                    nums[j] = true;
                }
            }
        }
    }
}
