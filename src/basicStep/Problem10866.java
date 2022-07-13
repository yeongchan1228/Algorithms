package basicStep;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem10866 { // 덱
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push_front" :
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if (!deque.isEmpty()) result.append(deque.pollFirst());
                    else result.append("-1");
                    result.append("\n");
                    break;
                case "pop_back" :
                    if(!deque.isEmpty()) result.append(deque.pollLast());
                    else result.append("-1");
                    result.append("\n");
                    break;
                case "size" :
                    result.append(deque.size() + "\n");
                    break;
                case "empty" :
                    if (deque.isEmpty()) result.append("1");
                    else result.append("0");
                    result.append("\n");
                    break;
                case "front" :
                    if (!deque.isEmpty()) result.append(deque.peekFirst());
                    else result.append("-1");
                    result.append("\n");
                    break;
                case "back" :
                    if (!deque.isEmpty()) result.append(deque.peekLast());
                    else result.append("-1");
                    result.append("\n");
                    break;
            }
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
