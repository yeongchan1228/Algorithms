package basicStep;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2870 { // 수학 숙제
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        ArrayList<String> nums = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+");

        while (n --> 0) {
            Matcher matcher = pattern.matcher(in.readLine());

            while (matcher.find()) {
                String val = matcher.group().replaceAll("^0+", "");
                nums.add(val.length() == 0 ? "0" : val);
            }
        }

        nums.stream().sorted((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length())
                .forEach(num -> result.append(num + "\n"));

        out.write(result.toString());
        out.flush();
        out.close();
        in.close();
    }

}
