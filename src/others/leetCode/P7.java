package others.leetCode;

public class P7 { // Reverse Integer
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean isMinus = false;
        StringBuilder answer = new StringBuilder();
        answer.append(x);
        if (x < 0) {
            isMinus = true;
            answer.deleteCharAt(0);
        }
        String reverseStr = answer.reverse().toString();

        if (isMinus) {
            if (reverseStr.length() == 10 && !isValid(reverseStr, String.valueOf(Integer.MIN_VALUE).substring(1))) {
                    return 0;
            }
            answer.insert(0, "-");
        } else {
            if (reverseStr.length() == 10 && !isValid(reverseStr, String.valueOf(Integer.MAX_VALUE))) {
                return 0;
            }
        }

        return Integer.parseInt(answer.toString());
    }

    private static boolean isValid(final String reverseStr, final String minValue) {
        for (int i = 0; i < 10; i++) {
            if (reverseStr.charAt(i) < minValue.charAt(i)) {
                break;
            }

            if (reverseStr.charAt(i) > minValue.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
