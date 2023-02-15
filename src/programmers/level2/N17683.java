package programmers.level2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N17683 { // 방금그곡

    public static void main(String[] args) throws IOException {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(new Solution().solution(m, musicinfos));
    }

    static class Solution {
        private static final int MINUTES = 60;
        private static Map<String, Character> map;
        public String solution(String m, String[] musicinfos) {
            map = getMap();

            m = convertMusic(m);

            int maxTime = 0;
            String answer = null;
            for (String musicinfo : musicinfos) {
                StringTokenizer st = new StringTokenizer(musicinfo, ",");
                int playTime = calcTime(st.nextToken(), st.nextToken());
                String musicName = st.nextToken();
                String renewalMusic = convertMusic(st.nextToken());

                int size = renewalMusic.length();
                StringBuilder finalMusic = new StringBuilder();
                if (playTime > size) {
                    finalMusic.append(renewalMusic);
                } else {
                    finalMusic.append(renewalMusic.substring(0, playTime));
                }

                for (int i = 0; i < playTime - size; i++) {
                    finalMusic.append(renewalMusic.charAt(i % size));
                }

                if (finalMusic.toString().contains(m)) {
                    if (playTime > maxTime) {
                        answer = musicName;
                        maxTime = playTime;
                    }
                }

            }
            return answer != null ? answer : "(None)";
        }

        private String convertMusic(String music) {
            char[] chars = music.toCharArray();
            StringBuilder renewalMusic = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '#') {
                    StringBuilder sb = new StringBuilder();
                    renewalMusic.deleteCharAt(renewalMusic.length() - 1);
                    sb.append(chars[i - 1]).append(chars[i]);
                    renewalMusic.append(map.get(sb.toString()));
                    continue;
                }
                renewalMusic.append(chars[i]);
            }
            return renewalMusic.toString();
        }

        private int calcTime(String startTime, String endTime) {
            return StringTimeToInt(endTime) - StringTimeToInt(startTime);
        }

        private int StringTimeToInt(String time) {
            StringTokenizer st = new StringTokenizer(time, ":");
            return Integer.parseInt(st.nextToken()) * MINUTES + Integer.parseInt(st.nextToken());
        }

        private Map<String, Character> getMap() {
            Map<String, Character> map = new HashMap<>();
            map.put("C#", '1');
            map.put("D#", '2');
            map.put("F#", '3');
            map.put("G#", '4');
            map.put("A#", '5');
            return map;
        }
    }

}
