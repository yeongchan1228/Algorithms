package programmers.level2;

import java.util.*;

public class N92341 { // 주차 요금 계산
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        for (int answer : new Solution().solution(fees, records)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            HashMap<String, Info> hashMap = new HashMap<>();
            for (String record : records) {
                StringTokenizer st = new StringTokenizer(record);
                String time = st.nextToken();
                String number = st.nextToken();
                String action = st.nextToken();

                st = new StringTokenizer(time, ":");
                String hourStr = st.nextToken();
                String minuteStr = st.nextToken();
                int calcTime = calcMinute(Integer.parseInt(hourStr), Integer.parseInt(minuteStr));
                if (action.equals("IN")) {
                    if (hashMap.containsKey(number)) {
                        Info info = hashMap.get(number);
                        info.inCar(calcTime);
                        continue;
                    }

                    hashMap.put(number, new Info(calcTime));
                } else {
                    Info info = hashMap.get(number);
                    info.calcTotalMinute(calcTime);
                }
            }

            int[] answer = new int[hashMap.size()];
            ArrayList<String> keyList = new ArrayList(hashMap.keySet());
            Collections.sort(keyList);
            for (int i = 0; i < keyList.size(); i++) {
                int totalPrice = 0;
                Info info = hashMap.get(keyList.get(i));
                if (info.isGone) {
                    totalPrice = calcTotalTime(info, fees[0], fees[1], fees[2], fees[3]);
                } else {
                    info.noOut();
                    totalPrice = calcTotalTime(info, fees[0], fees[1], fees[2], fees[3]);
                }
                answer[i] = totalPrice;
            }

            return answer;
        }

        public int calcTotalTime(Info info, int basicTime, int basicPrice, int unitTime, int unitPrice) {
            int totalPrice = 0;
            if (info.totalMinute <= basicTime) {
                totalPrice = basicPrice;
            } else {
                totalPrice = basicPrice + (int) Math.ceil(((info.totalMinute - basicTime) / (double) unitTime)) * unitPrice;
            }
            return totalPrice;
        }

        public int calcMinute(int hour, int minute) {
            return hour * 60 + minute;
        }

        public class Info {
            int inMinute;
            boolean isGone;
            int totalMinute;

            public Info(int inMinute) {
                inCar(inMinute);
                this.totalMinute = 0;
            }

            public void calcTotalMinute(int outMinute) {
                this.isGone = true;
                this.totalMinute += outMinute - inMinute;
            }

            public void inCar(int inMinute) {
                this.inMinute = inMinute;
                this.isGone = false;
            }

            public void noOut() {
                this.totalMinute += 1439 - this.inMinute;
            }
        }
    }
}
