package itis.grp403.TimurSibgatullin.HW2;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 5};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k)); // true
    }
}
