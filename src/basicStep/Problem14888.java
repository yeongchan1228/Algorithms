package basicStep;

import java.util.Scanner;

public class Problem14888 { // 연산자 끼워 넣기
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int N1 = 0;
    private static int[] lists;
    private static int[] operators;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N1 = in.nextInt();
        lists = new int[N1];
        operators = new int[4];

        for(int i = 0; i < N1; i++){
            lists[i] = in.nextInt();
        }

        for(int j = 0; j < 4; j++){
            operators[j] = in.nextInt();
        }

        calc(lists[0], 1);
        System.out.println(max);
        System.out.print(min);

    }

    public static void calc(int value, int dept){
        if(dept == N1){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){
                operators[i]--;
                switch (i) {
                    case 0 :
                        calc(value + lists[dept], dept+1);
                        break;

                    case 1 :
                        calc(value - lists[dept], dept+1);
                        break;

                    case 2 :
                        calc(value * lists[dept], dept+1);
                        break;

                    case 3 :
                        calc(value / lists[dept], dept+1);
                        break;
                }
                operators[i]++;
            }
        }


    }
}
