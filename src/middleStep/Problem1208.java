package middleStep;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1208 { // 부분수열의 합 2
    static List<Long> leftList = new ArrayList<>();
    static List<Long> rightList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        setList(0, n / 2, 0, arr, leftList);
        setList(n / 2, n, 0, arr, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        long answer = getAnswer(n, s);
        if (s == 0) {
            answer--;
        }

        out.write(String.valueOf(answer));
        out.flush();
        out.close();
    }

    private static void setList(final int idx, final int end, final long sum, final int[] arr, final List<Long> list) {
        if (idx == end) {
            list.add(sum);
            return;
        }

        setList(idx + 1, end, sum + arr[idx], arr, list);
        setList(idx + 1, end, sum, arr, list);
    }

    private static long getAnswer(final int n, final int s) {
        int start = 0;
        int end = rightList.size() - 1;
        long answer = 0;
        while (start < leftList.size() && end >= 0) {
            long sum = leftList.get(start) + rightList.get(end);

            if (sum == s) {
                long leftCnt = 0;
                long rightCnt = 0;
                long leftVal = leftList.get(start);
                while (start < leftList.size() && leftList.get(start) == leftVal) {
                    start++;
                    leftCnt++;
                }

                long rightVal = rightList.get(end);
                while (end >= 0 && rightList.get(end) == rightVal) {
                    end--;
                    rightCnt++;
                }
                answer += leftCnt * rightCnt;
            } else if (sum < s) {
                start++;
            } else {
                end--;
            }
        }

        return answer;
    }
}
