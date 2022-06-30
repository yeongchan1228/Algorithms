package basicStep;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1269 { // 대칭 차집합
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Iterator<Integer> iterator = setA.iterator();
        while (iterator.hasNext()){
            Integer a = iterator.next();
            if(setB.contains(a)){
                setB.remove(a);
                iterator.remove();
            }
        }

        out.write(String.valueOf(setA.size() + setB.size()));
        out.flush();
        out.close();
    }
}
