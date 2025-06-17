package itis.grp403.TimurSibgatullin;

import java.util.*;

public class Task3 {
    static int N;
    static List<Integer> current = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        gen(N, N);
    }

    static void gen(int currentSum, int max) {
        if (currentSum == 0) {
            pr();
            return;
        }

        for (int i = Math.min(currentSum, max); i >= 1; i--) {
            current.add(i);
            gen(currentSum - i, i);
            current.remove(current.size() - 1);
        }
    }

    static void pr() {
        for (int i = 0; i < current.size(); i++) {
            System.out.print(current.get(i));
            if (i < current.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
