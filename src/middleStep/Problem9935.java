package middleStep;

import java.io.*;

public class Problem9935 { // 문자열 폭발
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = in.readLine();
        String trigger = in.readLine();
        int triggerLen = trigger.length();
        StringBuilder sb = new StringBuilder();

        // 시간 초과
//        StringBuilder sb = new StringBuilder(str);
//        while (true){
//            int index = sb.lastIndexOf(trigger);
//            if(index == -1) break;
//            else{
//                sb.delete(index, index + triggerLen);
//            }
//        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            int sbLen = sb.length();
            if(sbLen >= triggerLen){
                boolean isSame = true;

                for (int j = 0; j < triggerLen; j++) {
                    char sbCh = sb.charAt(sbLen - triggerLen + j);
                    char triggerCh = trigger.charAt(j);

                    if(sbCh != triggerCh) {
                        isSame = false;
                        break;
                    }
                }

                if(isSame){
                    sb.delete(sbLen - triggerLen, sbLen);
                }
            }
        }

        if(sb.length() == 0) out.write("FRULA");
        else out.write(sb.toString());
        out.flush();
        out.close();
    }
}
