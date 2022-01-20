package basicStep;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem2667 {

    private static int count[];
    private static int arr[][];
    private static boolean check[][];
    private static int k = 0;
    private static int N = 0;
    private static String str = "";

    public static void find(int i, int j){
        check[i][j] = true;
        if(arr[i][j+1] == 1 && !check[i][j]){ // 오른쪽 검사
            count[k]++;
            find(i, j+1);
        }
        else if(arr[i+1][j] == 1&& !check[i+1][j]){ // 아래쪽 검사
            count[k]++;
            find(i+1, j);
        }
        else if(arr[i-1][j] == 1&& !check[i-1][j]){ // 위쪽 검사
            count[k]++;
            find(i-1, j);
        }
        else if(arr[i][j-1] == 1&& !check[i][j-1]){ // 왼쪽 검사
            count[k]++;
            find(i, j-1);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N+2][N+2];
        count = new int[N*N];
        check = new boolean[N][N];

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
        /*for(int i = 1; i < N+1; i++){
            for(int j = 1; j <N+1; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }*/

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(arr[i][j] == 1 && !check[i][j]){
                    find(i, j);
                    k++;
                }
            }
        }

        Arrays.sort(count);

        System.out.println(count.length);
        for(int i = 0; i < count.length; i++){
            if(i == count.length - 1)
                System.out.print(count[i]);
            else
                System.out.println(count[i]);
        }
    }
}
