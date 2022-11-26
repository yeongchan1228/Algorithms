package programmers.dev_matching;

import java.util.HashMap;

public class Dev2021_3 { // 다단계 칫솔 판매
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        Solution solution = new Solution();
        for (int answer : solution.solution(enroll, referral, seller, amount)) {
            System.out.println(answer);
        }
    }

     static class Solution {
         public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
             int[] answer = new int[enroll.length];

             HashMap<String, Person> map = new HashMap<>();
             for (int i = 0; i < enroll.length; i++) {
                 String name = enroll[i];
                 map.put(name, new Person(name));
             }

             for (int i = 0; i < referral.length; i++) {
                 String referralName = referral[i];
                 if (!referralName.equals("-")) {
                     map.get(enroll[i]).parent = map.get(referralName);
                 }
             }

             for (int i = 0; i < seller.length; i++) {
                 calc(map.get(seller[i]), amount[i] * 100);
             }

             for (int i = 0; i < enroll.length; i++) {
                 answer[i] = map.get(enroll[i]).profit;
             }

             return answer;
         }

         private void calc(Person person, int profit) {
             int calcProfit = profit / 10;
             if (calcProfit < 1) {
                 person.profit += profit;
                 return;
             }

             if (calcProfit >= 1) {
                 person.profit = person.profit + profit - calcProfit;
                 if (person.parent != null) {
                     calc(person.parent, calcProfit);
                 }
             }
         }

         public class Person {
             String name;
             Person parent;
             int profit = 0;

             public Person(String name) {
                 this.name = name;
             }
         }
    }
}
