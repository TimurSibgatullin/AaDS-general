package itis.grp403.TimurSibgatullin.Stack;

import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] array = {1, 2, 2, 3, 3, 4, 4, 4};
        for (int i = 0; i < array.length; i++) {
            if (stack.empty() || (stack.peek() != array[i])) {
                stack.push(array[i]);
            }
        }
        System.out.println(stack);
    }
}
