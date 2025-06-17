package itis.grp403.TimurSibgatullin;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();

        Set<Long> generated = new HashSet<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder());

        for (int i = 0; i < X.length(); i++) {
            int size = queue.size();
            char ch = X.charAt(i);

            for (int j = 0; j < size; j++) {
                StringBuilder current = queue.poll();

                queue.add(new StringBuilder(current));

                StringBuilder withDigit = new StringBuilder(current).append(ch);

                if (withDigit.length() <= 18 && !(withDigit.length() > 1 && withDigit.charAt(0) == '0')) {
                    try {
                        long value = Long.parseLong(withDigit.toString());
                        if (value >= 1 && value <= Integer.MAX_VALUE) {
                            generated.add(value);
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                queue.add(withDigit);
            }
        }

        long n = 1;
        while (true) {
            if (!generated.contains(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }
}
