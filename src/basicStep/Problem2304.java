package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2304 { // 창고 다각형

    static int[] heights;
    static int maxHeightX;

    public static void main(String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 1001;
        heights = new int[MAX];
        maxHeightX = Integer.MIN_VALUE;

        int end = Integer.MIN_VALUE;
        int start = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            heights[x] = height;

            end = Math.max(x, end);
            start = Math.min(x, start);
            if (height >= maxHeight) {
                maxHeight = height;
                maxHeightX = x;
            }
        }

        int result = heights[maxHeightX];
        result = calcLeft(start, result);
        result = calcRight(end, result);

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }

    private static int calcLeft(int start, int result) {
        for (int i = start; i < maxHeightX;) {
            int len = 1;
            for (int j = i + 1; j < maxHeightX; j++) {
                if (heights[i] < heights[j]) {
                    break;
                }
                len++;
            }
            result += (len * heights[i]);
            i += len;
        }
        return result;
    }

    private static int calcRight(int end, int result) {
        for (int i = end; i > maxHeightX;) {
            int len = 1;
            for (int j = i - 1; j > maxHeightX; j--) {
                if (heights[i] < heights[j]) {
                    break;
                }
                len++;

            }
            result += (len * heights[i]);
            i -= len;
        }
        return result;
    }

}
