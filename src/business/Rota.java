package business;

public class Rota<Localizacao> implements Comparable<Rota> {
    private final Localizacao current;
    private Localizacao previous;
    private double routeScore;
    private double estimatedScore;

    Rota(Localizacao current) {
        this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    Rota(Localizacao current, Localizacao previous, double routeScore, double estimatedScore) {
        this.current = current;
        this.previous = previous;
        this.routeScore = routeScore;
        this.estimatedScore = estimatedScore;
    }

    @Override
    public int compareTo(Rota other) {
        if (this.estimatedScore > other.estimatedScore) {
            return 1;
        } else if (this.estimatedScore < other.estimatedScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
