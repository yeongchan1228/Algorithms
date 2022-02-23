package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13335 { // 트럭
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        int cnt = Integer.parseInt(stringTokenizer.nextToken());
        int length = Integer.parseInt(stringTokenizer.nextToken());
        int weight = Integer.parseInt(stringTokenizer.nextToken());

        String[] trucks = in.readLine().split(" ");

        int weightSave = 0;
        for(int i = 0; i < cnt; i++){
            int check = Integer.parseInt(trucks[i]);

            while (true){
                if(queue.isEmpty()){
                    queue.offer(check);
                    weightSave += check;
                    result++;
                    break;
                }else if(queue.size() == length){
                    weightSave -= queue.poll();
                }else{
                    if(weightSave + check <= weight){
                        queue.offer(check);
                        weightSave += check;
                        result++;
                        break;
                    }else {
                        queue.offer(0);
                        result++;
                    }
                }
            }
        }
        System.out.println(result + length);
    }
}
