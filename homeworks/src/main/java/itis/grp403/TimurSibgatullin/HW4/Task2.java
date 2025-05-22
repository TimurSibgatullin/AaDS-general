package itis.grp403.TimurSibgatullin.HW4;

public class Task2 {
    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int start = 0;
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
    }

    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] input = "the sky is blue".toCharArray();
        reverseWords(input);
        System.out.println(new String(input));
    }
}

