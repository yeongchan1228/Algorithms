package middleStep;

import java.util.Scanner;

public class Problem2293 { // 동전 문제 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int count[] = new int[K + 1]; // 해당 인덱스 + 1 값을 만들 수 있는 개수 저장
        int values[] = new int[N]; // 각 동전의 가치
        for(int i = 0; i < N; i++){
            values[i] = in.nextInt();
        }

        count[0] = 1; // 0원이 되는 경우는 1가지
        for(int i = 0; i < N; i++){ // 동전의 모든 가치
            for(int j = values[i]; j <= K; j++){ // 만들 수 있는 값은 동전의 가치부터
                /* count[10] = count[9] + count[8] + count[5] */
                count[j] = count[j] + count[j - values[i]];

            }
        }

        System.out.print(count[K]);
    }
}
