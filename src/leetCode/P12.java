package leetCode;

public class P12 { // Integer to Roman
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                answer.append(str[i]);
                num -= value[i];
            }
        }

        return answer.toString();
    }
}
