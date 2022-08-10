package basicStep;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem10814 { // 나이순 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            persons[i] = (new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Arrays.sort(persons, Comparator.comparingInt(o -> o.age));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(persons[i] + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

    }
}
