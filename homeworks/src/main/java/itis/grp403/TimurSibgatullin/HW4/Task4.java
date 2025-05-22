package itis.grp403.TimurSibgatullin.HW4;
import java.util.*;

public class Task4 {
    public static int maxCount(int[] nums, int s) {
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (sum + num <= s) {
                sum += num;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {15, 5, 11, 10, 12};
        int s = 30;
        System.out.println(maxCount(nums, s));
    }
}
