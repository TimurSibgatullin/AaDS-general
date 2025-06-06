package itis.grp403.TimurSibgatullin.HW6;

public class Task1 {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] field = new int[n][m];

        field[0][0] = grid[0][0];

        for (int j = 1; j < m; j++) {
            field[0][j] = field[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            field[i][0] = field[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                field[i][j] = Math.min(field[i - 1][j], field[i][j - 1]) + grid[i][j];
            }
        }

        return field[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }
}