package programmers.kakao;

import java.util.HashMap;

public class Internship2022_1 { // 성격 유형 검사하기

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        char[] elements =  "RTCFJMAN".toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            hashMap.put(elements[i], 0);
        }

        final int standard = 4;
        for (int i = 0; i < survey.length; i++) {
            int val = choices[i];
            char[] chars = survey[i].toCharArray();
            if (val < standard) {
                hashMap.put(chars[0], hashMap.get(chars[0]) + (standard - val));
            } else if (val > standard) {
                hashMap.put(chars[1], hashMap.get(chars[1]) + (val - standard));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < elements.length; i += 2) {
            if (hashMap.get(elements[i]) < hashMap.get(elements[i + 1])) {
                answer.append(elements[i + 1]);
                continue;
            }

            answer.append(elements[i]);
        }

        System.out.println(answer.toString());
    }

}
