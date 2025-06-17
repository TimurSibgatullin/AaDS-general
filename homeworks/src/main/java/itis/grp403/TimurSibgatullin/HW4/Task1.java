package itis.grp403.TimurSibgatullin.HW4;

public class Task1 {
    public static int findIndex(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 2, 4, 6, 8};
        int j = findIndex(arr);
        System.out.println("индекс: " + j);
    }
}
