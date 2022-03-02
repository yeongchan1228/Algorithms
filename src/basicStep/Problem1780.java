package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1780 { // 종이의 개수

    static int[][] paper;
    static int[] check = {-1, 0, 1};
    static int count1 = 0; // -1 개수
    static int count2 = 0; // 0 개수
    static int count3 = 0; // 1 개수

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        paper = new int[N][N];
        StringTokenizer stringTokenizer;
        
        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        CheckValue(0, 0, N);

        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

    }

    static boolean isCheck(int col, int row, int len){
        int now = paper[col][row];

        for(int i = col; i < col+len; i++){
            for(int j = row; j < row+len; j++){
                if(paper[i][j] != now){
                    return false;
                }
            }
        }

        return true;
    }

    static void CheckValue(int col, int row, int len){

        if(isCheck(col, row, len)){
            if(paper[col][row] == check[0])
                count1++;
            else if(paper[col][row] == check[1])
                count2++;
            else if(paper[col][row] == check[2])
                count3++;
        }else{

            int nowL = len/3;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    CheckValue(col + nowL*i, row + nowL * j, nowL);
                }
            }
        }


    }
}
