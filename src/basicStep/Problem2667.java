package basicStep;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2667 { // 번지 번호 붙이기

    private static int count[];
    private static int arr[][];
    private static boolean check[][];
    private static int k = 0;
    private static int N = 0;
    private static String str = "";

    public static void find(int i, int j){ // 탐색
        check[i][j] = true;
        count[k]++;
        if(arr[i][j+1] == 1 && !check[i][j+1]){ // 오른쪽 검사
            find(i, j+1);
        }
        if(arr[i+1][j] == 1&& !check[i+1][j]){ // 아래쪽 검사
            find(i+1, j);
        }
        if(arr[i-1][j] == 1&& !check[i-1][j]){ // 위쪽 검사
            find(i-1, j);
        }
        if(arr[i][j-1] == 1&& !check[i][j-1]){ // 왼쪽 검사
            find(i, j-1);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N+2][N+2];
        count = new int[N*N];
        check = new boolean[N+2][N+2];

        for(int i = 0; i < N+2; i++){
            if(i != 0 && i != N+1)
                str = in.next();
            for(int j = 0; j < N+2; j++){
                if(i == 0 || i == N+1)
                    arr[i][j] = 0;
                else if(j == 0 || j == N+1)
                    arr[i][j] = 0;
                else
                    arr[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

        for(int i = 0; i < N+2; i++){
            for(int j = 0; j < N+2; j++){
                if(i == 0 || i == N+1)
                    check[i][j] = true;
                else if(j == 0 || j == N+1)
                    check[i][j] = true;
            }
        }

        for(int i = 1; i < N+1; i++){ // 정점 선택
            for(int j = 1; j < N+1; j++){
                if(arr[i][j] == 1 && !check[i][j]){
                    k++;
                    find(i, j);
                }
            }
        }

        Arrays.sort(count);

        System.out.println(k);

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0) {
                if (i == count.length - 1)
                    System.out.print(count[i]);
                else
                    System.out.println(count[i]);
            }
        }
    }
}
