package programmers.kakao;

import java.util.ArrayList;

public class Internship2020_2 {
    public static void main(String[] args) {
        String expression = "50*6-3*2";

        Solution solution = new Solution();
        System.out.println(solution.solution(expression));
    }

    static class Solution {
        public long solution(String expression) {
            char[] operations = {'+', '-', '*'};
            boolean[] isOperations = new boolean[operations.length];

            for (int i = 0; i < expression.length(); i++) {
                for (int j = 0; j < operations.length; j++) {
                    if (expression.charAt(i) == operations[j]) {
                        isOperations[j] = true;
                    }
                }
            }

            int start = 0;
            ArrayList<String> list = new ArrayList();
            for (int i = 0; i < expression.length(); i++) {
                for (int j = 0; j < operations.length; j++) {
                    if (expression.charAt(i) == operations[j]) {
                        list.add(expression.substring(start, i));
                        list.add(String.valueOf(operations[j]));
                        start = i + 1;
                    }
                }

                if (i == expression.length() - 1) {
                    list.add(expression.substring(start, i + 1));
                }
            }

            long answer = 0;
            for (int i = 0; i < operations.length; i++) {
                if (isOperations[i]) {
                    ArrayList<String> resultList1 = null;
                    ArrayList<String> resultList2 = null;
                    ArrayList<String> resultList3 = null;
                    resultList1 = calc(list, String.valueOf(operations[i]));

                    for (int j = 0; j < operations.length; j++) {
                        if (i == j) {
                            continue;
                        }

                        if (isOperations[j]) {
                            resultList2 = calc(resultList1, String.valueOf(operations[j]));

                            for (int k = 0; k < operations.length; k++) {
                                if (i == k || j == k) {
                                    continue;
                                }

                                if (isOperations[k]) {
                                    resultList3 = calc(resultList2, String.valueOf(operations[k]));
                                    answer = Math.max(answer, Math.abs(Long.parseLong(resultList3.get(0))));
                                }
                            }

                            if (resultList3 == null) {
                                answer = Math.max(answer, Math.abs(Long.parseLong(resultList2.get(0))));
                            }
                        }

                        if (resultList2 == null) {
                            answer = Math.max(answer, Math.abs(Long.parseLong(resultList1.get(0))));
                        }
                    }
                }
            }
            return answer;
        }

        private ArrayList<String> calc(ArrayList<String> list, String operation) {
            int idx = 0;
            ArrayList<String> resultList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String tmp = list.get(i);
                if (tmp.equals(operation)) {
                    String e = "";
                    e = getString(list, operation, idx, resultList, i);
                    resultList.add(e);
                    resultList.remove(idx - 1);
                    i++;
                    continue;
                }
                idx++;
                resultList.add(tmp);
            }
            return resultList;
        }

        private String getString(ArrayList<String> list, String operation, int idx, ArrayList<String> resultList, int i) {
            String result;
            if (operation.equals("+")) {
                result = String.valueOf(Long.parseLong(resultList.get(idx - 1)) + Long.parseLong(list.get(i + 1)));
            } else if (operation.equals("-")) {
                result = String.valueOf(Long.parseLong(resultList.get(idx - 1)) - Long.parseLong(list.get(i + 1)));
            } else {
                result = String.valueOf(Long.parseLong(resultList.get(idx - 1)) * Long.parseLong(list.get(i + 1)));
            }
            return result;
        }
    }
}
