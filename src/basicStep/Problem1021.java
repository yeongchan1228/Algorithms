package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1021 { // 회전하는 큐
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int[] arr = new int[M]; // 찾아야 하는 수
        stringTokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sum = 0; // 연산 수

        for(int i = 0; i < M; i++){
            int midIndex = 0;

            int listSize = list.size();
            if(listSize % 2 == 0){
                midIndex = (listSize - 1) / 2;
            }else{
                midIndex = listSize / 2;
            }

            int index = list.indexOf(arr[i]);

            if(index <= midIndex){ // 중간보다 작거나 같으면 앞의 수를 다 뒤로 보낸다 -> 2번
                for(int j = 0; j < index; j++){
                    int save = list.pollFirst();
                    list.offerLast(save);
                    sum++;
                }
            }else{ // 3번
                for(int j = listSize; j > index; j--){
                    int save = list.pollLast();
                    list.offerFirst(save);
                    sum++;
                }
            }
            list.pollFirst();
        }
        System.out.println(sum);
    }
}
