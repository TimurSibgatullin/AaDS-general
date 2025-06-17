package itis.grp403.TimurSibgatullin;

import java.util.*;

public class Task1 {
    static List<Deque<Integer>> stacks = new ArrayList<>();
    static List<String> moves = new ArrayList<>();
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            Deque<Integer> stack = new ArrayDeque<>();
            int[] items = new int[k];
            for (int j = 0; j < k; j++) {
                items[j] = sc.nextInt();
            }

            for (int j = k - 1; j >= 0; j--) {
                stack.push(items[j]);
            }
            stacks.add(stack);
        }

        solve();

        if (isSorted()) {
            for (String move : moves) {
                System.out.println(move);
            }
        } else {
            System.out.println(0);
        }
    }

    static void solve() {
        for (int target = 0; target < N; target++) {
            for (int s = 0; s < N; s++) {
                while (!stacks.get(s).isEmpty() && (s != target || stacks.get(s).peek() != target + 1)) {
                    int top = stacks.get(s).peek();
                    if (top == target + 1) {
                        move(s, target);
                    } else {
                        // Найти временную стопку, не равную s и target
                        boolean moved = false;
                        for (int t = 0; t < N; t++) {
                            if (t != s && t != target) {
                                move(s, t);
                                moved = true;
                                break;
                            }
                        }
                        if (!moved) return;
                    }
                }
            }
        }
    }

    static void move(int from, int to) {
        int container = stacks.get(from).pop();
        stacks.get(to).push(container);
        moves.add((from + 1) + " " + (to + 1));
    }

    static boolean isSorted() {
        for (int i = 0; i < N; i++) {
            for (int val : stacks.get(i)) {
                if (val != i + 1) return false;
            }
        }
        return true;
    }
}
