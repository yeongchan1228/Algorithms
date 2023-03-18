package middleStep;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problem14725 { // 개미굴
    private static final String DEPTH_STRING = "--";
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int size = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < size; j++) {
                String name = st.nextToken();

                if (!cur.childs.containsKey(name)) {
                    cur.childs.put(name, new Node());
                }
                cur = cur.childs.get(name);
            }
        }

        print(root, 0);

        out.write(answer.toString());
        out.flush();
        in.close();
        out.close();
    }

    private static void print(Node node, int depth) {
        List<String> keys = node.childs.keySet().stream().sorted().collect(Collectors.toList());

        for (String key : keys) {
            answer.append(DEPTH_STRING.repeat(depth) + key + "\n");
            print(node.childs.get(key), depth + 1);
        }
    }

    private static class Node {
        HashMap<String, Node> childs = new HashMap<>();
    }
}
