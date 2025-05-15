package itis.grp403.TimurSibgatullin.HW2;
import java.util.*;

public class Task3 {
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for (int num : nums1) {
            count1.put(num, count1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key : count1.keySet()) {
            if (count2.containsKey(key)) {
                int minCount = Math.min(count1.get(key), count2.get(key));
                for (int i = 0; i < minCount; i++) {
                    result.add(key);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 4, 1};
        int[] nums2 = {2, 2, 4, 5};
        List<Integer> result = intersect(nums1, nums2);
        System.out.println(result);
    }
}
