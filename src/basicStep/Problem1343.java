package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1343 { // 폴리오미노
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] poly = {"AAAA", "BB"};

        String str = in.readLine();

        //풀이 1
        /*
        String result = "";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '.'){
                if(count % 2 == 0) { // 채울 수 있음
                    // 4개 채울 수 있는지
                    int four = count / 4;
                    if (four > 0) {
                        for (int j = 0; j < four; j++) {
                            result += poly[0];
                        }
                        count %= 4;
                        if (count == 0) {
                            result += ch;
                            continue;
                        }
                    }

                    //2개 채울 수 있는지
                    if(count != 0){
                        int two = count / 2;
                        if (two > 0 && count % 2 == 0) {
                            count = 0;
                            for (int j = 0; j < two; j++) {
                                result += poly[1];
                            }
                            result += ch;
                        } else {
                            System.out.println("-1");
                            return;
                        }
                    }else{
                        result += ch;
                    }
                }else{
                    System.out.println("-1");
                    return;
                }
            }
            else {
                count++;
            }
        }

        if(count > 0 && count % 2 == 0) {
            // 4개 채울 수 있는지
            int four = count / 4;
            if (four > 0) {
                for (int j = 0; j < four; j++) {
                    result += poly[0];
                }
                count %= 4;
            }
            if (count != 0) {
                //2개 채울 수 있는지
                int two = count / 2;
                if (two > 0 && count % 2 == 0) {
                    count = 0;
                    for (int j = 0; j < two; j++) {
                        result += poly[1];
                    }
                } else {
                    System.out.println("-1");
                    return;
                }
            }
        }else if(count == 0){
            System.out.println(result);
            return;
        }
        else{
            System.out.println("-1");
            return;
        }
        */
        // 풀이 2
        str = str.replaceAll("XXXX", poly[0]);
        str = str.replaceAll("XX", poly[1]);

        if(str.contains("X")){
            System.out.println("-1");
        }else {
            System.out.println(str);
        }
    }
}
