package leetCode;

public class P6 { // Zigzag Conversion
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int idx = -1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                sb[++idx].append(s.charAt(i));
            } else {
                sb[--idx].append(s.charAt(i));
            }

            if (idx == numRows - 1) {
                flag = false;
                continue;
            }

            if (idx == 0 && !flag) {
                flag = true;
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}
