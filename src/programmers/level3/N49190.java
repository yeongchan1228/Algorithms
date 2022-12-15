package programmers.level3;

import java.util.*;

public class N49190 { // 방의 개수
    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(new Solution().solution(arrows));
    }

    static class Solution {

        static final int SCALE_UP_SIZE = 2;
        static HashMap<Info, ArrayList<Info>> hashMap;

        public int solution(int[] arrows) {
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {1, 1, 0, -1,-1, -1, 0, 1};

            hashMap = new HashMap<>();
            Info currentInfo = new Info(0, 0);

            int answer = 0;
            for (int arrow : arrows) {
                for (int i = 0; i < SCALE_UP_SIZE; i++) {
                    Info nextInfo = new Info(currentInfo.x + dx[arrow], currentInfo.y + dy[arrow]);

                    if (!hashMap.containsKey(nextInfo)) {
                        setHashMapWithNewList(nextInfo, currentInfo);

                        if (!hashMap.containsKey(currentInfo)) {
                            setHashMapWithNewList(currentInfo, nextInfo);
                        } else {
                            hashMap.get(currentInfo).add(nextInfo);
                        }
                    } else {
                        if (!hashMap.get(nextInfo).contains(currentInfo)) {
                            hashMap.get(nextInfo).add(currentInfo);
                            hashMap.get(currentInfo).add(nextInfo);
                            answer++;
                        }
                    }

                    currentInfo = nextInfo;
                }
            }

            return answer;
        }

        private void setHashMapWithNewList(Info keyInfo, Info valueInfo) {
            ArrayList<Info> newList = new ArrayList<>();
            newList.add(valueInfo);
            hashMap.put(keyInfo, newList);
        }

        public class Info {
            int x;
            int y;

            public Info(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Info info = (Info) o;
                return x == info.x && y == info.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}
