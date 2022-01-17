package basicStep;

import java.util.Scanner;

public class Problem3085 { // 사탕 게임
    private static int N = 0;
    private static int count = 1;
    private static int max = Integer.MIN_VALUE;

    public static void calc(char[][] box){ // 계산 부분
        for(int k = 0; k < N; k++){

            for(int p = 1; p < N; p++){ // 행 비교
                if(box[k][p] == box[k][p-1]){
                    count++;
                }
                else
                    count = 1;
                max = Math.max(max, count);
            }
            count = 1;
            for(int p = 1; p < N; p++){ // 열 비교
                if(box[p][k] == box[p-1][k]){
                    count++;
                }
                else
                    count = 1;
                max = Math.max(max, count);
            }
            count = 1;
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        char box[][] = new char[N][N];
        char swp;

        for (int i = 0; i < N; i++){ // 배열에 집어 넣기
            String str = in.next();
            for(int j = 0; j < N; j++){
                box[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
//                box[i][j]; // 본인
//                box[i-1][j]; // 위 방향
//                box[i+1][j]; // 아래 방향
//                box[i][j+1]; // 오른쪽 방향
//                box[i][j-1]; // 왼쪽 방향

                if(j + 1 < N){ // 맨 마지막 열 제외
                    //오른 쪽 방향 변경
                    swp = box[i][j];
                    box[i][j] = box[i][j+1];
                    box[i][j+1] = swp;

                    calc(box);

                    swp = box[i][j];
                    box[i][j] = box[i][j+1];
                    box[i][j+1] = swp;
                }
                if(i + 1 < N){ // 맨 마지막 행 제외
                    //아래 쪽 방향 변경
                    swp = box[i][j];
                    box[i][j] = box[i+1][j];
                    box[i+1][j] = swp;

                    calc(box);

                    swp = box[i][j];
                    box[i][j] = box[i+1][j];
                    box[i+1][j] = swp;
                }

            }
        }

        System.out.print(max);
    }
}
