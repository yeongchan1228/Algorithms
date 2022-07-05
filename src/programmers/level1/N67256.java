package programmers.level1;

public class N67256 { // 키패드 누르기
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        hand = hand.equals("right") ? "R" : "L";
        String answer = "";
        int[][] numPoint = {{1, 0}, {0, 3}, {1, 3}, {2, 3}, {0, 2}, {1, 2}, {2, 2}, {0, 1}, {1, 1}, {2, 1}};

        Point lPoint = new Point(0, 0);
        Point rPoint = new Point(2, 0);

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer = getAnswer(answer, "L", lPoint, numPoint[number]);
            } else if (number == 3 || number == 6 || number == 9) {
                answer = getAnswer(answer, "R", rPoint, numPoint[number]);
            } else {
                int dirL = getDir(new Point(numPoint[number][0], numPoint[number][1]), lPoint);
                int dirR = getDir(new Point(numPoint[number][0], numPoint[number][1]), rPoint);

                if (dirL < dirR) {
                    answer = getAnswer(answer, "L", lPoint, numPoint[number]);
                } else if (dirL > dirR) {
                    answer = getAnswer(answer, "R", rPoint, numPoint[number]);
                } else {
                    answer = getAnswer(answer, hand, rPoint, numPoint[number]);
                }
            }
        }

        System.out.println(answer);
    }

    private static String getAnswer(String answer, String dir, Point point, int[] numPoint) {
        answer += dir;
        point.x = numPoint[0];
        point.y = numPoint[1];
        return answer;
    }

    private static int getDir(Point x, Point y) {
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
