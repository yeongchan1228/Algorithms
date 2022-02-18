package basicStep;

import java.util.Scanner;

public class Problem16113 { // 시그널

    static int N, row, col;
    static StringBuilder[] stringBuilder;
    static StringBuilder fin;

    static String zero = "######...######";
    static String one = "#####";
    static String two = "#.####.#.####.#";
    static String three = "#.#.##.#.######";
    static String four = "###....#..#####";
    static String five = "###.##.#.##.###";
    static String six = "######.#.##.###";
    static String seven = "#....#....#####";
    static String eight = "######.#.######";
    static String nine = "###.##.#.######";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        row= N / 5;
        col = 5;
        StringBuilder[] result = new StringBuilder[row];
        stringBuilder = new StringBuilder[col];
        fin = new StringBuilder();
        for(int i = 0 ; i < col; i++){
            stringBuilder[i] = new StringBuilder();
        }
        for(int i = 0; i < row; i++){
            result[i] = new StringBuilder();
        }

        String str = in.next();

        int j = 0;
        for(int i = 0; i < col; i++){
            stringBuilder[i].append(str.substring(j, j+row));
            j += row;
        }


        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                result[i].append(stringBuilder[k].charAt(i));
            }
        }

        for(int i = 0; i < row; i++){
            if(result[i].toString().equals(one) && i == row - 1){
                fin.append("1");
            }
            else if(result[i].toString().equals(one) && i != row - 1 && result[i+1].toString().equals(".....")){
                fin.append("1");
            }
            else{
                if(i < row - 2){
                    if(result[i].toString().equals(".....")){
                        continue;
                    }
                    String number = result[i].toString() + result[i+1].toString() + result[i+2].toString();

                    if(number.equals(zero)){
                        fin.append("0");
                    }
                    else if(number.equals(two)){
                        fin.append("2");
                    }
                    else if(number.equals(three)){
                        fin.append("3");
                    }
                    else if(number.equals(four)){
                        fin.append("4");
                    }
                    else if(number.equals(five)){
                        fin.append("5");
                    }
                    else if(number.equals(six)){
                        fin.append("6");
                    }
                    else if(number.equals(seven)){
                        fin.append("7");
                    }
                    else if(number.equals(eight)){
                        fin.append("8");
                    }
                    else if(number.equals(nine)){
                        fin.append("9");
                    }

                    i += 2;
                }
            }
        }

        System.out.println(fin.toString());
    }
}
