package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1316 { // 그룹 단위 체커
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        String[] str = new String[N];
        boolean[] alphabet = new boolean[26];
        
        for (int i = 0; i < N; i++) {
            str[i] = in.readLine();
        }

        char ch ='.'; // 이전 결과 저장
        int count = 0;

        for (int i = 0; i < N; i++) {
            count++;
            for (int j = 0; j < str[i].length(); j++) {
                char now = str[i].charAt(j);
                if(ch != now && alphabet[now - 'a']){
                    count--;
                    break;
                }
                alphabet[now - 'a'] = true;
                ch = str[i].charAt(j);
            }
            ch = '.';
            alphabet = new boolean[26];
        }

        System.out.println(count);
    }
}
