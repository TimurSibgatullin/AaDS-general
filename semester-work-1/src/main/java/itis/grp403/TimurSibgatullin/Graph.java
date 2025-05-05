package itis.grp403.TimurSibgatullin;

import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> graph;
    List<Integer> visited;
    int iterationCount;
    long duration;


    public Graph(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.visited = new ArrayList<>();
        iterationCount = 0;
        duration = 0;
    }

    public List<Integer> BFS(Integer vertex) {
        Queue<Integer> readyToBurn = new LinkedList<>();
        this.iterationCount = 0;
        long startTime = System.nanoTime();
        readyToBurn.add(vertex);
        while (!readyToBurn.isEmpty()) {
            visited.add(readyToBurn.peek());
            for (Integer descendant : graph.get(readyToBurn.poll())) {
                this.iterationCount++;
                if (!visited.contains(descendant) & !readyToBurn.contains(descendant)) {
                    readyToBurn.add(descendant);
                }
            }
        }
        long endTime = System.nanoTime();
        duration = endTime - startTime;
        return visited;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public long getDuration() {
        return duration;
    }
}
