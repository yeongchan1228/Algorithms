package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem8911 { // 거북이

    static int N;
    static char[] move = {'F', 'B', 'L', 'R'};
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static char[] map;
    static int distanceMovedX = 0, distanceMovedY = 0, watch = 0;
    static int plusX = 0, plusY = 0, minusX = 0, minusY = 0;

    static void moving(int num, char c){
       /* if(num == 0 || num == 2){ // +Y 방향
            if(c == 'F') {
                distanceMovedY += moveY[num];
                distanceMovedX += moveX[num];
            }
            else{
                distanceMovedY -= moveY[num];
                distanceMovedX -= moveX[num];
            }
        }
        else if(num == 1 || num == 3){ // +X 방향
            if(c == 'F') {
                distanceMovedY += moveY[num];
                distanceMovedX += moveX[num];
            }
            else{
                distanceMovedY -= moveY[num];
                distanceMovedX -= moveX[num];
            }
        }*/

        if(c == move[0]){
            distanceMovedX += moveX[num];
            distanceMovedY += moveY[num];
        }
        else if(c == move[1]){
            distanceMovedX -= moveX[num];
            distanceMovedY -= moveY[num];
        }

        plusY = Math.max(plusY, distanceMovedY);
        minusY = Math.min(minusY, distanceMovedY);
        plusX = Math.max(plusX, distanceMovedX);
        minusX = Math.min(minusX, distanceMovedX);
    }

    static void selectW(int num, char c){
   /*     if(num == 0 && c == 'R'){
            watch = 1;
        }
        else if( num == 0 && c == 'L'){
            watch = 3;
        }
        else if( num == 1 && c == 'L'){
            watch = 0;
        }else if( num == 1 && c == 'R'){
            watch = 2;
        }
        else if( num == 2 && c == 'L'){
            watch = 1;
        }
        else if( num == 2 && c == 'R'){
            watch = 3;
        }
        else if( num == 3 && c == 'L'){
            watch = 2;
        }
        else if( num == 3 && c == 'R'){
            watch = 0;
        }*/

        if(c == move[2]){
            if(watch == 0)
                watch =3;
            else
                watch--;
        }
        else if(c == move[3]){
            if(watch == 3)
                watch = 0;
            else
                watch++;
        }
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int[] ans = new int[N];

        for(int i = 0; i < N; i++){
            String str = in.readLine();
            map = new char[str.length()];

            for(int j = 0; j < str.length(); j++){
                map[j] = str.charAt(j);

                if(map[j] == move[0]){ // 'F'
                    moving(watch, move[0]);
                }
                else if(map[j] == move[1]){ // 'B'
                    moving(watch, move[1]);
                }
                else if(map[j] == move[2]){ // 'L'
                    selectW(watch, move[2]);
                }
                else if(map[j] == move[3]){ // 'R'
                    selectW(watch, move[3]);
                }
            }
            ans[i] = (Math.abs(minusY) + plusY) * (Math.abs(minusX) + plusX);
            plusX = 0;
            minusX = 0;
            minusY = 0;
            plusY = 0;
            distanceMovedX = 0;
            distanceMovedY = 0;
            watch = 0;
        }

        for(int i = 0; i < N; i++){
            System.out.println(ans[i]);
        }
    }
}
