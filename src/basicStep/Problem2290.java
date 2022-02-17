package basicStep;

import java.util.Scanner;

public class Problem2290 { // LCD 테스트

    static StringBuilder[] stringBuilder;
    static int s;
    static int col;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        s = in.nextInt();
        String str = in.next();
        int len = str.length();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = Character.getNumericValue(str.charAt(i));
        }

        int row = s+2; // 가로
        col = 2 * s + 3; // 세로
        //char[][] map = new char[col * len][row * len + len];
        stringBuilder = new StringBuilder[col];
        for(int i = 0; i < col; i++){
            stringBuilder[i] = new StringBuilder();
        }

        for(int i = 0; i < len; i++){
            switch (nums[i]) {
                case 1:
                    top1();
                    mid1();
                    mid_f1();
                    mid1_2();
                    bot1();
                    break;
                case 2:
                    top2();
                    mid1();
                    mid_f2();
                    mid3_2();
                    bot2();
                    break;
                case 3:
                    top2();
                    mid1();
                    mid_f2();
                    mid1_2();
                    bot2();
                    break;
                case 4:
                    top1();
                    mid2();
                    mid_f2();
                    mid1_2();
                    bot1();
                    break;
                case 5:
                    top2();
                    mid3();
                    mid_f2();
                    mid1_2();
                    bot2();
                    break;
                case 6:
                    top2();
                    mid3();
                    mid_f2();
                    mid2_2();
                    bot2();
                    break;
                case 7:
                    top2();
                    mid1();
                    mid_f1();
                    mid1_2();
                    bot1();
                    break;
                case 8:
                    top2();
                    mid2();
                    mid_f2();
                    mid2_2();
                    bot2();
                    break;
                case 9:
                    top2();
                    mid2();
                    mid_f2();
                    mid1_2();
                    bot2();
                    break;
                case 0:
                    top2();
                    mid2();
                    mid_f1();
                    mid2_2();
                    bot2();
                    break;
            }
        }

        for(int i = 0; i < col; i++)
            System.out.println(stringBuilder[i]);

    }

    public static void top1(){ // 0 0 0
        for(int i = 0; i < s+2; i++){
            stringBuilder[0].append(' ');
        }
        stringBuilder[0].append(' ');
    }

    public static void top2(){ // 0 - - 0
        stringBuilder[0].append(' ');
        for(int i = 0; i < s; i++){
            stringBuilder[0].append('-');
        }
        stringBuilder[0].append(' ');
        stringBuilder[0].append(' ');
    }

    public static void bot1(){ // 0 0 0 0
        for(int i = 0; i < s+2; i++)
            stringBuilder[col - 1].append(' ');
        stringBuilder[col - 1].append(' ');
    }

    public static void bot2(){ // 0 - - 0
        stringBuilder[col - 1].append(' ');
        for(int i = 0; i < s; i++){
            stringBuilder[col - 1].append('-');
        }
        stringBuilder[col - 1].append(' ');
        stringBuilder[col - 1].append(' ');
    }
    public static void mid1(){ // 0 0 0 |
        for(int j = 0; j < s+3; j++) {
            for (int i = 1; i <= s; i++) {
                if(j == s+1) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid2(){ // | 0 0 |
        for(int j = 0; j < s+3; j++) {
            for (int i = 1; i <= s; i++) {
                if(j == 0 || j == s+1) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid3(){ // | 0 0 0
        for(int j = 0; j < s+3; j++) {
            for (int i = 1; i <= s; i++) {
                if(j == 0) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid1_2(){ // 0 0 0 |
        for(int j = 0; j < s+3; j++) {
            for (int i = 2+s; i < (s + (2+s)); i++) {
                if(j == s+1) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid2_2(){ // | 0 0 |
        for(int j = 0; j < s+3; j++) {
            for (int i = 2+s; i < (s + (2+s)); i++) {
                if(j == 0 || j == s+1) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid3_2(){ // | 0 0 0
        for(int j = 0; j < s+3; j++) {
            for (int i = 2+s; i < (s + (2+s)); i++) {
                if(j == 0) {
                    stringBuilder[i].append('|');
                }
                else
                    stringBuilder[i].append(' ');
            }
        }
    }

    public static void mid_f1(){ // 0 0 0 0
        for(int i = 0; i < s+2; i++){
            stringBuilder[s+1].append(' ');
        }
        stringBuilder[s+1].append(' ');
    }

    public static void mid_f2(){ // 0 - - 0
        stringBuilder[s+1].append(' ');
        for(int i = 0; i < s; i++){
            stringBuilder[s+1].append('-');
        }
        stringBuilder[s+1].append(' ');
        stringBuilder[s+1].append(' ');
    }
}
