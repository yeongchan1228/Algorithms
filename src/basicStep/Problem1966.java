package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1966 { // 프린터 큐
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] priority;
        PriorityQueue<Integer> priorityQueue;
        int result = 1;
        ArrayList<Integer> fin = new ArrayList<>();

        int N = Integer.parseInt(in.readLine());

        int cnt, index;
        for(int i = 0; i < N; i++){
            StringTokenizer stringTokenizer1 = new StringTokenizer(in.readLine());
            cnt = Integer.parseInt(stringTokenizer1.nextToken());
            index = Integer.parseInt(stringTokenizer1.nextToken());
            boolean flag = false;

            priority = new int[cnt];
            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            String[] s = in.readLine().split(" ");


            for(int k = 0; k < s.length; k++){
                priority[k] = Integer.parseInt(s[k]);
                priorityQueue.add(Integer.parseInt(s[k]));
            }

            while (!priorityQueue.isEmpty()) {

                for (int j = 0; j < cnt; j++) {
                    if(priorityQueue.peek() == priority[j]){
                        if(j == index){
                            flag = true;
                            break;
                        }else{
                            priorityQueue.poll();
                            result++;
                        }
                    }
                }
                if(flag)
                    break;

            }
            fin.add(result);
            result = 1;
        }

        Iterator<Integer> iterator = fin.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
