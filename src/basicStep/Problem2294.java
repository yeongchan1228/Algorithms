package basicStep;

import java.util.Scanner;

public class Problem2294 { // 동전 2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int coin[] = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = in.nextInt();
        }

        int count[] = new int[K+1]; // 동전의 개수
        count[0] = 0;
        for(int i = 1; i < K+1; i++){ // 최대로 가질 수 있는 동전 개수로 초기화(
            count[i] = K + 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j <= K; j++){
                count[j] = Math.min(count[j], (count[j - coin[i]] + 1));
                //System.out.println("count [" + j + "] : "+"coin : "+count[j]);
            }
        }

        if(count[K] == K+1){
            System.out.print("-1");
        }
        else
            System.out.print(count[K]);

    }
}
