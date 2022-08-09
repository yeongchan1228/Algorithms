package basicStep;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem10825 { // 국영수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
//        String[][] studentInfo = new String[n][4];

//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(in.readLine());
//            for (int j = 0; j < 4; j++) {
//                studentInfo[i][j] = st.nextToken();
//            }
//        }

        Queue<Student> pq = new PriorityQueue<>();
         for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            pq.add(new Student(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
         }

        StringBuilder result = new StringBuilder();
//        Arrays.stream(studentInfo).sorted(((o1, o2) -> {
//                    if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
//                        if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
//                            if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
//                                return o1[0].compareTo(o2[0]);
//                            }
//                            return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
//                        }
//                        return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
//                    }
//                    return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
//        })).map(strings -> strings[0]).forEach(name -> result.append(name + "\n"));

        while (!pq.isEmpty()) {
            Student student = pq.poll();

            result.append(student.name + "\n");
        }
        out.write(result.toString());
        out.flush();
        out.close();
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                if (this.english == o.english) {
                    if (this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.english - o.english;
            }
            return o.korean - this.korean;
        }
    }
}
