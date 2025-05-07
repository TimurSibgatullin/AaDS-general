package itis.grp403.TimurSibgatullin;

public class Result {
    private int vertices;
    private int edges;
    private double timeMillis;
    private int steps;

    public Result(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public double getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = (double) timeMillis / 1000000;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                ", timeMillis=" + timeMillis +
                ", steps=" + steps +
                '}';
    }
}
