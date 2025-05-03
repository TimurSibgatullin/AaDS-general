package itis.grp403.TimurSibgatullin.Stack;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String string = sc.nextLine();
        int result = 0;
        for (String i : string.split(" ")) {
            if (!(i.equals("+")) && (!(i.equals("-")) && (!(i.equals("*"))))) {
                stack.push(Integer.parseInt(i));
                System.out.println(stack);
            } else {
                int y = stack.pop();
                int x = stack.pop();
                switch (i) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                }
            }
        }
        System.out.println(stack);
    }
}

