package itis.grp403.TimurSibgatullin.HW7;

import java.util.Arrays;

public class Task1 {
    public static int[] closestTripletNlogN(int[] nums, int t) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int[] bestTriplet = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == t) {
                    return new int[]{nums[i], nums[left], nums[right]};
                }
                if (Math.abs(sum - t) < Math.abs(closestSum - t)) {
                    closestSum = sum;
                    bestTriplet[0] = nums[i];
                    bestTriplet[1] = nums[left];
                    bestTriplet[2] = nums[right];
                }
                if (sum < t) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return bestTriplet;
    }
}
