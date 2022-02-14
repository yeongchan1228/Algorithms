package basicStep;

import java.util.Scanner;

public class Problem3568 { // iSharp 문제

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] result = str.split(" ");

        for(int i = 0; i < result.length; i++) {
            result[i] = result[i].replace(",","");
            result[i] = result[i].replace(";","");
        }

        StringBuilder store = new StringBuilder();
        StringBuilder store2 = new StringBuilder();
        StringBuilder name = new StringBuilder(); // 변수 명

        int num = 0;
        boolean isName = false;
        for(int i = 1; i < result.length; i++){
           for(num = 0; num < result[i].length(); num++){
                if(result[i].charAt(num) == '&'){
                    if(!isName)
                        store.append("&");
                    else
                        store2.append("&");
                }
                else if(result[i].charAt(num) == '['){
                    if(result[i].charAt(num+1) == ']'){
                        if(!isName)
                            store.append("[]");
                        else
                            store2.append("][");
                        num += 1;
                    }
                }
                else if(result[i].charAt(num) == '*'){
                    if(!isName)
                        store.append("*");
                    else
                        store2.append("*");
                }
                else {
                    name.append(result[i].charAt(num));
                    isName = true;
                }
            }
           store2.reverse();

           result[i] = result[0] +  store + store2 + " " + name + ";";

           store.setLength(0);
           store2.setLength(0);
           name.setLength(0);
           isName = false;
        }

        for(int i = 1; i < result.length; i++){
            System.out.println(result[i]);
        }


    }
}
