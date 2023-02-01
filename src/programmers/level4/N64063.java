package programmers.level4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N64063 { // 호텔 방 배정
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        for (long answer : new Solution().solution(k, room_number)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static Map<Long, Long> map = new HashMap<>();

        public long[] solution(long k, long[] room_number) {
            int idx = -1;
            long[] answer = new long[room_number.length];
            for (long room : room_number) {
                idx++;
                answer[idx] = findRoom(room);
            }

            return answer;
        }

        private long findRoom(long room) {
            if (!map.containsKey(room)) {
                map.put(room, room + 1);
                return room;
            }

            long emptyRoom = findRoom(map.get(room));
            map.put(room, emptyRoom);
            return emptyRoom;
        }
    }
}
