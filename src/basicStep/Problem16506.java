package basicStep;

import java.util.Scanner;

public class Problem16506 { // CPU

    public static String calc(String str, int check){
        int num = Integer.parseInt(str);
        int value = 0;
        StringBuilder result = new StringBuilder();

        if(str.equals("0") && check == 0){
            return "000";
        }else {
            while (num > 0) {
                value = num % 2;
                num /= 2;
                result.append(Integer.toString(value));
            }
            if(check == 0) {
                if (result.length() < 3) {
                    for (int k = result.length(); k < 3; k++) {
                        result.append("0");
                    }
                }
            }
            else {
                if (result.length() < 4) {
                    for (int k = result.length(); k < 4; k++) {
                        result.append("0");
                    }
                }
            }

            result.reverse();
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String[] cmd = new String[N]; // 0~5 비트
        String[] rD = new String[N];
        String[] rA = new String[N];
        String[] rB = new String[N];

        for(int i = 0; i < N; i++){
            String str = in.next();
            if(str.equals("ADD"))
                cmd[i] = "000000";
            else if(str.equals("ADDC"))
                cmd[i] = "000010";
            else if(str.equals("SUB"))
                cmd[i] = "000100";
            else if(str.equals("SUBC"))
                cmd[i] = "000110";
            else if(str.equals("MOV"))
                cmd[i] = "001000";
            else if(str.equals("MOVC"))
                cmd[i] = "001010";
            else if(str.equals("AND"))
                cmd[i] = "001100";
            else if(str.equals("ANDC"))
                cmd[i] = "001110";
            else if(str.equals("OR"))
                cmd[i] = "010000";
            else if(str.equals("ORC"))
                cmd[i] = "010010";
            else if(str.equals("NOT"))
                cmd[i] = "010100";
            else if(str.equals("MULT"))
                cmd[i] = "011000";
            else if(str.equals("MULTC"))
                cmd[i] = "011010";
            else if(str.equals("LSFTL"))
                cmd[i] = "011100";
            else if(str.equals("LSFTLC"))
                cmd[i] = "011110";
            else if(str.equals("LSFTR"))
                cmd[i] = "100000";
            else if(str.equals("LSFTRC"))
                cmd[i] = "100010";
            else if(str.equals("ASFTR"))
                cmd[i] = "100100";
            else if(str.equals("ASFTRC"))
                cmd[i] = "100110";
            else if(str.equals("RL"))
                cmd[i] = "101000";
            else if(str.equals("RLC"))
                cmd[i] = "101010";
            else if(str.equals("RR"))
                cmd[i] = "101100";
            else if(str.equals("RRC"))
                cmd[i] = "101110";

            rD[i] = in.next();
            rA[i] = in.next();
            rB[i] = in.next();
        }

        for(int i = 0; i < N; i++){
            if(cmd[i].charAt(4) == '0'){
                System.out.println(cmd[i] + calc(rD[i],0) + calc(rA[i], 0) + calc(rB[i], 0) + "0");
            }
            else{
                System.out.println(cmd[i] + calc(rD[i], 0) + calc(rA[i], 0) + calc(rB[i], 1));
            }

        }
    }
}
