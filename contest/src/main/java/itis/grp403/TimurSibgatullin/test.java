package itis.grp403.TimurSibgatullin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] ints = new int[100];

    static void generate(int n, int max, int depth) {
        if (n == 0) {
            for (int i = 0; i < depth; i++) {
                stringBuilder.append(ints[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = Math.min(n, max); i >= 1; i--) {
            ints[depth] = i;
            generate(n - i, i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        generate(N, N, 0);

        System.out.print(stringBuilder);
    }
}
