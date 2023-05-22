package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P54 { // Spiral Matrix
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int j = leftCol; j <= rightCol; j++) {
                answer.add(matrix[topRow][j]);
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                answer.add(matrix[i][rightCol]);
            }
            rightCol--;

            if (topRow <= bottomRow) {
                for (int j = rightCol; j >= leftCol; j--) {
                    answer.add(matrix[bottomRow][j]);
                }
                bottomRow--;
            }

            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    answer.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return answer;
    }
}
