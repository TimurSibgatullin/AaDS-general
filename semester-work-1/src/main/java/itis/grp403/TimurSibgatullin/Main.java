package itis.grp403.TimurSibgatullin;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Result> results1 = new ArrayList<>();
//        for (int i = 1; i < 101; i++) {
//            Graph graph = new Graph(i * 100, (i * 100) - 1);
//            graph.BFS(0);
//            results1.add(graph.getStats());
//        }
//        CSVWriter.saveResultsToCSV("trees.txt", results1);

//        List<Result> results2 = new ArrayList<>();
//        for (int i = 1; i < 101; i++) {
//            Graph graph = new Graph(i * 100, ((i * 100) * ((int) (Math.log(i * 100) / Math.log(2)))));
//            graph.BFS(0);
//            results2.add(graph.getStats());
//        }
//        CSVWriter.saveResultsToCSV("mediumCompleteGraph.txt", results2);
//
        List<Result> results3 = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            Graph graph = new Graph(i * 100, (i * 100 * i * 100));
            graph.BFS(0);
            System.out.println(i);
            results3.add(graph.getStats());
        }
        CSVWriter.saveResultsToCSV("fullCompleteGraph.txt", results3);
    }
}
