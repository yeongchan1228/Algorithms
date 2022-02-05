package basicStep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1076 { // 저항
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, num> map = new HashMap<>();
        map.put(0, new num("black",0, 1));
        map.put(1, new num("brown",1, 10));
        map.put(2, new num("red",2, 100));
        map.put(3, new num("orange",3, 1000));
        map.put(4, new num("yellow",4, 10000));
        map.put(5, new num("green",5, 100000));
        map.put(6, new num("blue",6, 1000000));
        map.put(7, new num("violet",7, 10000000));
        map.put(8, new num("grey",8, 100000000));
        map.put(9, new num("white",9, 1000000000));


        String N1 = in.next();
        String N2 = in.next();
        String N3 = in.next();

        String str = "";
        String str2 = "";
        long mul = 0;
        for(int i = 0; i < 10; i++){
            if(N1.equals(map.get(i).getColor())){
                str = Integer.toString(map.get(i).getValue());
                break;
            }
        }
        for(int i = 0; i < 10; i++){
            if(N2.equals(map.get(i).getColor())){
                str2 = Integer.toString(map.get(i).getValue());
                break;
            }
        }
        for(int i = 0; i < 10; i++){
            if(N3.equals(map.get(i).getColor())){
                mul = map.get(i).getMulti();
                break;
            }
        }

        long result = Integer.parseInt(str + str2);
        result = result * mul;

        System.out.print(result);

    }

}

class num{
    String color;
    int value;
    int multi;

    public num(String color,int value, int multi) {
        this.color = color;
        this.value = value;
        this.multi = multi;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public int getMulti() {
        return multi;
    }
}
