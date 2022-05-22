package middleStep;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem5430 { // AC
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> deque;

        int N = Integer.parseInt(in.readLine());


        for (int i = 0; i < N; i++) {
            String cmd = in.readLine();
            int cnt = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), "[],");
            deque = new ArrayDeque<>();
            while (st.hasMoreTokens()){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            boolean checkBack = false;
            boolean checkError = false;
            for (int j = 0; j < cmd.length(); j++) {
                char ch = cmd.charAt(j);
                if(ch == 'R') checkBack = !checkBack;
                else{
                    int size = deque.size();
                    if(size == 0) {
                        checkError = true;
                        out.write("error" + "\n");
                        break;
                    }
                    if(checkBack) deque.removeLast();
                    else deque.remove();
                }
            }
            if (checkError) continue;

            printResult(out, deque, checkBack);
        }
        out.flush();
        out.close();
    }

    private static void printResult(BufferedWriter out, Deque<Integer> deque, boolean checkBack) throws IOException {
        int size = deque.size();
        if(size == 0) out.write("[]" + "\n");
        else {
            out.write("[");
            if (checkBack) {
                for (int j = 0; j < size; j++) {
                    if (j == size - 1) out.write(deque.pollLast() + "]" + "\n");
                    else out.write(deque.pollLast() + ",");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    if (j == size - 1) {
                        Integer integer = deque.pollFirst();
                        out.write(integer + "]" + "\n");
                    } else {
                        Integer integer = deque.pollFirst();
                        out.write(integer + ",");

                    }
                }
            }
        }
    }
}
