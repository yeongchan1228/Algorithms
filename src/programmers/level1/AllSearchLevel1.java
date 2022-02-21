package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class AllSearchLevel1 { // 모의고사
    public static void main(String[] args) {
        int[] p1 = {1, 2, 3, 4, 5}; // 5개
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개

        int[] ans = {1,3,2,4,2};
        int[] correct = new int[3];

        for(int i = 0; i < ans.length; i++){
            if(ans[i] == p1[i % 5]){
                correct[0]++;
            }
            if(ans[i] == p2[i % 8]){
                correct[1]++;
            }
            if(ans[i] == p3[i % 10]){
                correct[2]++;
            }
        }
        OptionalInt max = Arrays.stream(correct).max();
        ArrayList<Integer> find = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            if(max.getAsInt() == correct[i]){
                find.add(i + 1);
            }
        }

        int[] answer = new int[find.size()];
        for(int i = 0; i < find.size(); i++){
            answer[i] = find.get(i);
        }

        System.out.println("answer : " + Arrays.toString(answer));
    }
}
