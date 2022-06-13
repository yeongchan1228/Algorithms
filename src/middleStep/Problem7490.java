package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7490 { // 0 만들기

    static StringBuilder sb = new StringBuilder();
    static List<Character> list = new ArrayList<>();
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(in.readLine());
//            dfs(1, "1");
//            sb.append("\n");
            dfs(1);
            sb.append("\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

//    static void dfs(int depth, String str){
//        if(num == depth){
//            String replaceStr = str.replaceAll(" ", "");
//            String[] split = replaceStr.split("[+,-]");
//            Iterator<Integer> iterator = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList()).iterator();
//            int result = iterator.next();
//            for (int i = 1; i < replaceStr.length(); i++) {
//                if(replaceStr.charAt(i) == '+') result += iterator.next();
//                else if(replaceStr.charAt(i) == '-') result -= iterator.next();
//            }
//            if(result == 0) sb.append(str + "\n");
//            return;
//        }
//
//        dfs(depth + 1, str + " " + (depth + 1));
//        dfs(depth + 1, str + "+" + (depth + 1));
//        dfs(depth + 1, str + "-" + (depth + 1));
//    }

    static void dfs(int depth){
        if(num == depth){
            int num = 1;
            int tmp = 1;
            int sum = 0;
            StringBuilder exp = new StringBuilder(String.valueOf(num));
            for (Character ch : list){
                exp.append(ch);
                exp.append(++num);

                if(ch == ' '){
                    tmp *= 10;
                    if(tmp < 0) tmp -= num;
                    else tmp += num;
                }else if(ch == '+'){
                    sum += tmp;
                    tmp = num;
                }else if(ch == '-'){
                    sum += tmp;
                    tmp = -num;
                }
            }

            if(sum+tmp == 0) sb.append(exp + "\n");

            return;
        }

        list.add(' ');
        dfs(depth + 1);
        list.remove(depth - 1);

        list.add('+');
        dfs(depth + 1);
        list.remove(depth - 1);

        list.add('-');
        dfs(depth + 1);
        list.remove(depth - 1);
    }
}
