package basicStep;

import java.io.*;
import java.util.HashSet;

public class Problem9536 { // 여우는 어떻게 울지?
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] sounds = in.readLine().split(" ");
            HashSet<String> hashSet = new HashSet<>();
            while (true) {
                String str = in.readLine();
                String[] splits = str.split(" ");

                if (!splits[1].equals("goes")) break;
                hashSet.add(splits[2]);
            }

            for (int j = 0; j < sounds.length; j++) {
                if (!hashSet.contains(sounds[j])) {
                    result.append(sounds[j] + " ");
                }
            }

            result.append("\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
