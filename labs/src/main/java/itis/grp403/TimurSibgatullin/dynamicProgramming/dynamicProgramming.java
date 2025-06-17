package itis.grp403.TimurSibgatullin.dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class dynamicProgramming {
    public static int ways(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int val : queue) {
                sum += val;
            }

            queue.add(sum);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        return ((LinkedList<Integer>) queue).getLast();
    }

    public static void main(String[] args) {
        int N = 7;
        int K = 2;
        System.out.println(ways(N, K));
    }
}
