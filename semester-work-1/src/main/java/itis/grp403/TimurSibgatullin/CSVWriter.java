package itis.grp403.TimurSibgatullin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void saveResultsToCSV(String filename, List<Result> results) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Vertices;Edges;Time(ms);Steps\n");
            for (Result result : results) {
                writer.write(result.getVertices() + ";" +
                        result.getEdges() + ";" +
                        result.getTimeMillis() + ";" +
                        result.getSteps() + "\n");
            }

            System.out.println("CSV файл успешно сохранён: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении CSV: " + e.getMessage());
        }
    }
}