package business.gLocalizacao;

public class Rota implements Comparable<Rota> {
    private final int current;
    private Rota previous;
    private double value;

    Rota(int current) {
        this.current = current;
        this.previous = null;
        this.value = 0;
    }

    Rota(int current, Rota previous, double value) {
        this.current = current;
        this.previous = previous;
        this.value = value;
    }

    public int getCurrent() {
        return current;
    }

    public Rota getPrevious() {
        return previous;
    }
    public void setPrevious(Rota previous) {
        this.previous = previous;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void incrementValue(double value){
        this.value = this.value+value;
    }

    @Override
    public int compareTo(Rota other) { //não sei se o comparador tem de ficar assim ou ao contrario
        return Double.compare(this.value, other.getValue());
    }
}


