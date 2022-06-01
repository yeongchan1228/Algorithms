package programmers.test;

public class LevelTest1_2 { // 절댓값 정수 배열
    public static void main(String[] args) {
        int[] a = {4,7,12};
        boolean[] s = {true,false,true};

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if(s[i]) result += a[i];
            else  result -= a[i];
        }

        System.out.println("result = " + result);
    }

}
