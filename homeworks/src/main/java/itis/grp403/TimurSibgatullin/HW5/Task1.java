package itis.grp403.TimurSibgatullin.HW5;

public class Task1 {
    public static String addBinary(String a, String b) {
        int a1 = Math.max(a.length(), b.length());
        a = padLeft(a, a1);
        b = padLeft(b, a1);

        StringBuilder stringBuilder = new StringBuilder();
        int c = 0;

        for (int i = a1 - 1; i >= 0; i--) {
            int bA = a.charAt(i) - '0';
            int bB = b.charAt(i) - '0';
            int sum = bA + bB + c;
            stringBuilder.insert(0, sum % 2);
            c = sum / 2;
        }

        if (c > 0) stringBuilder.insert(0, '1');
        return stringBuilder.toString();
    }

    public static String subtractBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        a = padLeft(a, maxLength);
        b = padLeft(b, maxLength);

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int bA = a.charAt(i) - '0' - borrow;
            int bB = b.charAt(i) - '0';
            if (bA < bB) {
                bA += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.insert(0, bA - bB);
        }

        return stripLeadingZeros(result.toString());
    }

    public static String konosuba(String x, String y) {
        x = stripLeadingZeros(x);
        y = stripLeadingZeros(y);

        int n = Math.max(x.length(), y.length());
        if (n == 0) return "0";
        if (n == 1) {
            return Integer.toString((x.charAt(0) - '0') * (y.charAt(0) - '0'));
        }

        n = (n % 2 == 0) ? n : n + 1;
        x = padLeft(x, n);
        y = padLeft(y, n);

        int half = n / 2;

        String x1 = x.substring(0, half);
        String x0 = x.substring(half);
        String y1 = y.substring(0, half);
        String y0 = y.substring(half);

        String z2 = konosuba(x1, y1);
        String z0 = konosuba(x0, y0);
        String x1Plusx0 = addBinary(x1, x0);
        String y1Plusy0 = addBinary(y1, y0);
        String z1 = konosuba(x1Plusx0, y1Plusy0);
        z1 = subtractBinary(z1, addBinary(z2, z0));

        String result = addBinary(shiftLeft(z2, 2 * half),
                addBinary(shiftLeft(z1, half), z0));
        return stripLeadingZeros(result);
    }

    private static String shiftLeft(String s, int n) {
        if (s.equals("0")) return "0";
        return s + "0".repeat(n);
    }

    private static String padLeft(String s, int n) {
        return "0".repeat(n - s.length()) + s;
    }

    private static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    public static void main(String[] args) {
        String a = "1101"; // 13
        String b = "1011"; // 11
        String result = konosuba(a, b);
        System.out.println(result);
        // 10001111 (13 * 11 = 143)
    }
}