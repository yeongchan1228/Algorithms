package programmers.test;

public class LevelTest1_1 { // 다트 게임
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        char[] chars = dartResult.toCharArray();
        int[] round = new int[3];

        int roundCnt = -1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                roundCnt++;
                round[roundCnt] = Integer.parseInt(String.valueOf(chars[i]));
                if(i+1 <= chars.length && chars[i] == '1' && chars[i+1] == '0'){
                    round[roundCnt] = 10;
                    i++;
                }
            }else if(chars[i] == 'D'){
                round[roundCnt] *= round[roundCnt];
            }else if(chars[i] == 'T'){
                round[roundCnt] = round[roundCnt] * round[roundCnt] * round[roundCnt];
            }else if(chars[i] == '*'){
                if(roundCnt > 0) round[roundCnt - 1] *= 2;
                round[roundCnt] *= 2;
            }else if(chars[i] == '#'){
                round[roundCnt] *= -1;
            }
        }

        System.out.println(round[0] + round[1] + round[2]);
    }
}
