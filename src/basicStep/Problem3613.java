package basicStep;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3613 { // Java vs C++
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = in.readLine();

        // 오류 조건
        if(line.matches("^([A-Z]|(_)).*") || line.matches(".*(_){2,}.*")
                || line.matches(".*(_)$") || line.length() == 0 || (line.contains("_") && line.matches(".*[A-Z].*"))) {
            out.write("Error!");
        }else{
            Matcher matcher;
            if(line.contains("_")) {
                matcher = Pattern.compile("(?:_([a-z]))").matcher(line);
                while (matcher.find()){
                    line = line.replace(matcher.group(), matcher.group(1).toUpperCase());
                }
            }else if(line.matches(".*[A-Z].*")){
                matcher = Pattern.compile("(?:[A-Z])").matcher(line);
                while (matcher.find()){
                    line = line.replace(matcher.group(), "_" + matcher.group().toLowerCase());
                }
            }

            out.write(line);
        }

        out.flush();
        out.close();
    }
}
