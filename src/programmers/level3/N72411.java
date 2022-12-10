package programmers.level3;

import java.util.*;

public class N72411 { // 메뉴 리뉴얼
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        for (String answer : new Solution().solution(orders, course)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static Map<String, Integer> saveOrders = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> answerList = new ArrayList<>();

            for (int cnt : course) {
                for (String order : orders) {
                    char[] orderChs = order.toCharArray();
                    Arrays.sort(orderChs);
                    dfs(0, 0, cnt, orderChs, new char[cnt]);
                }

                int maxVal = Integer.MIN_VALUE;
                if (!saveOrders.isEmpty()) {
                    for (int value : saveOrders.values()) {
                        if (value > 1 && value > maxVal) {
                            maxVal = value;
                        }
                    }

                    for (Map.Entry<String, Integer> entry : saveOrders.entrySet()) {
                        if (entry.getValue() == maxVal) {
                            answerList.add(entry.getKey());
                        }
                    }
                }

                saveOrders.clear();
            }

            Collections.sort(answerList);

            return answerList.toArray(String[]::new);
        }

        private void dfs(int depth, int start, int size, char[] order, char[] selected) {
            if (size > order.length) {
                return;
            }

            if (depth == size) {
                String selectedOrder = String.valueOf(selected);
                saveOrders.put(selectedOrder, saveOrders.getOrDefault(selectedOrder, 0) + 1);
                return;
            }

            for (int i = start; i < order.length; i++) {
                selected[depth] = order[i];
                dfs(depth + 1, i + 1, size, order, selected);
            }

        }
    }
}
