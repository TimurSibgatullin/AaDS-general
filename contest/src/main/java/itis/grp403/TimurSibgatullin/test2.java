

import java.util.*;

public class test2 {
    static int[][] nextPos;
    static String X;
    static int n;
    static Boolean[][] memo;
    static char[] number;
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextLine();
        n = X.length();

        nextPos = new int[n + 2][10];
        for (int d = 0; d < 10; d++) {
            nextPos[n][d] = -1;
            nextPos[n + 1][d] = -1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int d = 0; d < 10; d++) {
                nextPos[i][d] = nextPos[i + 1][d];
            }
            nextPos[i][X.charAt(i) - '0'] = i;
        }

        for (length = 1; length <= n + 1; length++) {
            memo = new Boolean[length + 1][n + 2];
            number = new char[length];
            if (dfs(0, 0)) {
                System.out.println(new String(number));
                return;
            }
        }
    }


    static boolean dfs(int pos, int posX) {
        if (pos == length) {
            return false;
        }
        if (memo[pos][posX] != null) return memo[pos][posX];

        int startDigit = (pos == 0) ? 1 : 0;

        for (int d = startDigit; d <= 9; d++) {
            int next = (posX == -1) ? -1 : nextPos[posX][d];
            if (next == -1) {

                number[pos] = (char) (d + '0');
                for (int i = pos + 1; i < length; i++) {
                    number[i] = '0';
                }
                memo[pos][posX] = true;
                return true;
            } else {
                number[pos] = (char) (d + '0');
                if (dfs(pos + 1, next + 1)) {
                    memo[pos][posX] = true;
                    return true;
                }
            }
        }
        memo[pos][posX] = false;
        return false;
    }
}


