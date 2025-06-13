package itis.grp403.TimurSibgatullin.HW7;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static boolean[] getWinningPositions(int n, List<List<Integer>> moves) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = false;
            for (int move : moves.get(i)) {
                if (i - move >= 0 && !dp[i - move]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> moves = new ArrayList<>();
        moves.add(List.of());
        moves.add(List.of(1));
        moves.add(List.of(1));
        moves.add(List.of(1, 2));
        moves.add(List.of(1, 3));
        moves.add(List.of(2, 3));
        boolean[] dp = getWinningPositions(n, moves);
        if (dp[n]) {
            System.out.println("Первый игрок выиграет");
        } else {
            System.out.println("Второй игрок выиграет");
        }
    }
}
