package itis.grp403.TimurSibgatullin.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MergeQueues {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(1);
        q1.add(3);
        q1.add(5);

        q2.add(2);
        q2.add(4);
        q2.add(6);

        Queue<Integer> merged = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                merged.add(q1.poll());
            } else {
                merged.add(q2.poll());
            }
        }

        while (!q1.isEmpty()) {
            merged.add(q1.poll());
        }

        while (!q2.isEmpty()) {
            merged.add(q2.poll());
        }
        System.out.println(merged);
    }
}
