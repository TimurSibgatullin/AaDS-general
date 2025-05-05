package itis.grp403.TimurSibgatullin;

import java.util.*;

public class GraphGenerator {
    private static Random random = new Random();

    public static Map<Integer, List<Integer>> generateSampleGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4, 5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList());

        return graph;
    }

    public static Map<Integer, List<Integer>> generateRandomGraph(int vertices, int edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Случайным образом добавляем рёбра
        for (int i = 0; i < edges; i++) {
            int from = random.nextInt(vertices);
            int to = random.nextInt(vertices);
            if (from != to) { // Избегаем петель
                graph.get(from).add(to);
            }
        }

        return graph;
    }

}
