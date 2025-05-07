package itis.grp403.TimurSibgatullin;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> graph;
    private List<Integer> visited;
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
        this.visited = new ArrayList<>();
    }

    public List<Integer> BFS(Integer startVertice) {
        Queue<Integer> readyToBurn = new LinkedList<>();
        int iterationCount = 0;
        long startTime = System.nanoTime();
        readyToBurn.add(startVertice);
        while (!readyToBurn.isEmpty()) {
            visited.add(readyToBurn.peek());
            for (Integer descendant : graph.get(readyToBurn.poll())) {
                iterationCount++;
                if (!visited.contains(descendant) & !readyToBurn.contains(descendant)) {
                    readyToBurn.add(descendant);
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
