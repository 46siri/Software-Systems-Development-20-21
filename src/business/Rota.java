package business;

public class Rota<L extends Localizacao> implements Comparable<Rota> {
    private final L current;
    private L previous;
    private double routeScore;
    private double estimatedScore;

    Rota(L current) {
        this(current, null, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    Rota(L current, L previous, double routeScore, double estimatedScore) {
        this.current = current;
        this.previous = previous;
        this.routeScore = routeScore;
        this.estimatedScore = estimatedScore;
    }

    public L getCurrent() {
        return current;
    }

    public L getPrevious() {
        return previous;
    }
    public void setPrevious(L previous) {
        this.previous = previous;
    }

    public double getRouteScore() {
        return routeScore;
    }
    public void setRouteScore(double routeScore) {
        this.routeScore = routeScore;
    }

    public double getEstimatedScore() {
        return estimatedScore;
    }
    public void setEstimatedScore(double estimatedScore) {
        this.estimatedScore = estimatedScore;
    }

    @Override
    public int compareTo(Rota other) {
        if (this.estimatedScore > other.getEstimatedScore()) {
            return 1;
        } else if (this.estimatedScore < other.getEstimatedScore()) {
            return -1;
        } else {
            return 0;
        }
    }

}
