package itis.grp403.TimurSibgatullin;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Result> results1 = new ArrayList<>();
//        for (int i = 1; i < 101; i++) {
//            Graph graph1 = new Graph(i * 100, (i * 100) - 1);
//            graph1.BFS(0);
//            results1.add(graph1.getStats());
//        }
//        CSVWriter.saveResultsToCSV("trees", results1);
        List<Result> results2 = new ArrayList<>();
        for (int i = 100; i < 101; i++) {
            Graph graph1 = new Graph(i * 100, (i * 1000));
            graph1.BFS(0);
            System.out.println(i);
            results2.add(graph1.getStats());
        }
        CSVWriter.saveResultsToCSV("mediumCompleteGraph", results2);
    }
}
