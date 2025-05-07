package itis.grp403.TimurSibgatullin;


public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Graph graph1 = new Graph(10000, 10000);
            graph1.BFS(0);
            System.out.println(graph1.getStats());
        }
    }
}
