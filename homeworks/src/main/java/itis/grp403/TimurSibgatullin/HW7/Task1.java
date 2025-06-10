package itis.grp403.TimurSibgatullin.HW7;

import java.util.HashSet;

public class Task1 {
    public static int[] closestTripletLinear(int[] nums, int t) {
        int n = nums.length;
        int bestDiff = Integer.MAX_VALUE;
        int[] result = new int[3];

        // Будем хранить все ранее встреченные числа
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                int c = t - a - b;

                // Проверим, что c не равен a и b, и что он есть в массиве
                if (c != a && c != b && contains(nums, c, i, j)) {
                    return new int[]{a, b, c};
                }
            }
        }

        return result; // если точная тройка не найдена
    }

    public static boolean contains(int[] nums, int target, int skip1, int skip2) {
        for (int k = 0; k < nums.length; k++) {
            if (k != skip1 && k != skip2 && nums[k] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 1, 9, 3, 7};
        int t = 20;
        for (int i : closestTripletLinear(nums, t)) {
            System.out.println(i);
        }
    }
}
