package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1755 { // 숫자 놀이
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int size = (M - N) + 1;
        int[] arrI = new int[size];
        for(int i = 0; i < size; i++, N++){
            arrI[i] = N;
        }

        String[] arrS = new String[size];
        for(int i = 0; i < size; i++){
            arrS[i] = Integer.toString(arrI[i]);
        }


        for(int i = 0; i < size; i++){
            String str = arrS[i];
            int strLength = str.length();
            arrS[i] = "";

            for(int j = 0; j < strLength; j++){
                if(str.charAt(j) == '0')
                    arrS[i] = arrS[i] + "zero";
                else if(str.charAt(j) == '1')
                    arrS[i] = arrS[i] + "one";
                else if(str.charAt(j) == '2')
                    arrS[i] = arrS[i] + "two";
                else if(str.charAt(j) == '3')
                    arrS[i] = arrS[i] + "three";
                else if(str.charAt(j) == '4')
                    arrS[i] = arrS[i] + "four";
                else if(str.charAt(j) == '5')
                    arrS[i] = arrS[i] + "five";
                else if(str.charAt(j) == '6')
                    arrS[i] = arrS[i] + "six";
                else if(str.charAt(j) == '7')
                    arrS[i] = arrS[i] + "seven";
                else if(str.charAt(j) == '8')
                    arrS[i] = arrS[i] + "eight";
                else if(str.charAt(j) == '9')
                    arrS[i] = arrS[i] + "nine";

                arrS[i] = arrS[i] + " ";
            }
        }

        Arrays.sort(arrS);

        for(int i = 0; i < size; i++){
            String[] str = arrS[i].split(" ");
            int strLength = str.length;
            arrS[i] = "";

            for(int j = 0; j < strLength; j++){
                if(str[j].equals("zero") && j > 0)
                    arrS[i] = arrS[i] + "0";
                else if(str[j].equals("one"))
                    arrS[i] = arrS[i] + "1";
                else if(str[j].equals("two"))
                    arrS[i] = arrS[i] + "2";
                else if(str[j].equals("three"))
                    arrS[i] = arrS[i] + "3";
                else if(str[j].equals("four"))
                    arrS[i] = arrS[i] + "4";
                else if(str[j].equals("five"))
                    arrS[i] = arrS[i] + "5";
                else if(str[j].equals("six"))
                    arrS[i] = arrS[i] + "6";
                else if(str[j].equals("seven"))
                    arrS[i] = arrS[i] + "7";
                else if(str[j].equals("eight"))
                    arrS[i] = arrS[i] + "8";
                else if(str[j].equals("nine"))
                    arrS[i] = arrS[i] + "9";
            }
        }

        for(int i = 0; i < size; i++){
            if(i > 0 && i % 10 == 0){
                System.out.println();
            }
            System.out.print(arrS[i] +" ");
        }
    }
}
