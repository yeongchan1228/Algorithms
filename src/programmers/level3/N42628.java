package programmers.level3;

import java.util.StringTokenizer;
import java.util.TreeMap;

public class N42628 { // 이중우선순위큐
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        for (int answer : new Solution().solution(operations)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(String[] operations) {
            // 최대, 최소
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (String operation : operations) {
                StringTokenizer st = new StringTokenizer(operation);
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    if (treeMap.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        int maxKey = treeMap.lastKey();
                        int val = treeMap.get(maxKey);
                        if (val > 1) {
                            treeMap.put(maxKey, val - 1);
                            continue;
                        }

                        treeMap.remove(maxKey);
                    } else if (num == -1) {
                        int minKey = treeMap.firstKey();
                        int val = treeMap.get(minKey);
                        if (val > 1) {
                            treeMap.put(minKey, val - 1);
                            continue;
                        }

                        treeMap.remove(minKey);
                    }
                }
            }

            return treeMap.size() > 0 ? new int[]{treeMap.lastKey(), treeMap.firstKey()} : new int[]{0, 0};
        }
    }
}
