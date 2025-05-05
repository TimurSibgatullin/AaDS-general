package itis.grp403.TimurSibgatullin;


public class Main {
    public static void main(String[] args) {
        Graph graph1 = new Graph(GraphGenerator.generateSampleGraph());
        System.out.println(graph1.BFS(0));
        System.out.println(graph1.getDuration());
        System.out.println(graph1.getIterationCount());
    }
}