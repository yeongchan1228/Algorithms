package programmers.level1;

public class Level1N81301 { // 숫자 문자열과 영단어
    public static void main(String[] args) {
        String s = "one4seveneight";

        int answer = 0;
        String[] numbersS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] numbersI = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < numbersS.length; i++) {
            boolean contains = s.contains(numbersS[i]);
            while (contains) {
                s = s.replace(numbersS[i], String.valueOf(numbersI[i]));

                contains = s.contains(numbersS[i]);
            }
        }

        answer = Integer.parseInt(s);
        System.out.println(answer);
    }
}
