package programmers.level2;

public class N60057 { // 문자열 압축
    public static void main(String[] args) {
        String s = "a";

        int answer = Integer.MAX_VALUE;
        String result;

        if (s.length() == 1){
            answer = 1;
        }

        for (int i = 1; i <= (s.length()/2); i++) {
            int cnt = 0;
            result = "";

            String substring = s.substring(0, i);

            for (int j = 0; true; j+=i) {

                if((j + i) > s.length()) {
                    if(cnt > 1) {
                        result += cnt + substring;
                    }else{
                        result += substring;
                    }
                    if(j < s.length())
                        result += s.substring(j, s.length());
                    break;
                }

                String compare = s.substring(j, (j + i));

                if(compare.equals(substring)) {
                    cnt++;
                }
                else{
                    if(cnt > 1) {
                        result += cnt + substring;
                    }else{
                        result += substring;
                    }

                    substring = compare;
                    cnt = 1;
                }
            }
            System.out.println("result = " + result);
            answer = Math.min(result.length(), answer);
        }

        System.out.println("answer = " + answer);
    }
}
