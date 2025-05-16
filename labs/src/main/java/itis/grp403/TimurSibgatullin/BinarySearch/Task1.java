package itis.grp403.TimurSibgatullin.BinarySearch;

public class Task1 {
    public static void main(String[] args) {
        String s = "aabaa";
        String t = "aaaab";

        int shift = getShiftAmount(t, s);
        if (shift != -1) {
            System.out.println("s является сдвигом t на " + shift + " символов вправо.");
        } else {
            System.out.println("s не является сдвигом t.");
        }
    }

    public static int getShiftAmount(String original, String shifted) {
        if (original.length() != shifted.length()) return -1;

        String doubled = original + original;
        int index = doubled.indexOf(shifted);

        if (index != -1 && index < original.length()) {
            return index;
        }

        return -1;
    }
}
