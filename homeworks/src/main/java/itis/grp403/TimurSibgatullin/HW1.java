package itis.grp403.TimurSibgatullin;

import java.util.Scanner;
import java.util.Stack;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String string = sc.next();
        for (int i = 0; i < string.length(); i++) {
            char next = string.charAt(i);
            if (next == '(' || next == '{' || next == '[') {
                stack.push(next);
            } else {
                switch (next) {
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            System.out.println("Не подходит");
                            return;
                        };
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            System.out.println("Не подходит");
                            return;
                        };
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            System.out.println("Не подходит");
                            return;
                        };
                        break;
                }
            }
        }
        System.out.println("Подходит");

    }
}
