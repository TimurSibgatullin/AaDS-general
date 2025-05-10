package itis.grp403.TimurSibgatullin;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;
    private Result result;
    private static Random random = new Random();

    private Map<Integer, List<Integer>> generateRandomGraph(int vertices, int edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> notConnected = new ArrayList<>();
        List<Integer> connected = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            notConnected.add(i);
        }

        connected.add(notConnected.remove(random.nextInt(vertices)));
        for (int i = 0; i < edges; i++) {
            int fromIdx = 0;
            Integer first = null;
            Integer second = null;
            if (!notConnected.isEmpty()) {
                first = notConnected.get(random.nextInt(notConnected.size()));
                notConnected.remove(first);
                second = connected.get(random.nextInt(connected.size()));
            } else {
                first = random.nextInt(vertices);
                second = random.nextInt(vertices);
            }
            if (!Objects.equals(first, second)) {
                graph.get(first).add(second);
                graph.get(second).add(first);
            }
        }
        return graph;
    }

    public Graph(int vertices, int edges) {
        result = new Result(vertices, edges);
        this.graph = generateRandomGraph(vertices, edges);
        this.visited = new HashSet<>();
    }

    public Set<Integer> BFS(Integer startVertice) {
        Queue<Integer> burning = new LinkedList<>();
        int iterationCount = 0;
        long startTime = System.nanoTime();
        burning.add(startVertice);
        visited.add(startVertice);

        while (!burning.isEmpty()) {
            Integer current = burning.poll();
            for (Integer descendant : graph.getOrDefault(current, List.of())) {
                iterationCount++;
                if (!visited.contains(descendant)) {
                    burning.add(descendant);
                    visited.add(descendant);
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        result.setTimeMillis(duration);
        result.setSteps(iterationCount);
        return visited;
    }

    public Result getStats() {
        return result;
    }
}
