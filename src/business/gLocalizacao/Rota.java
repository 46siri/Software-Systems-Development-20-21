package business.gLocalizacao;

public class Rota implements Comparable<Rota> {
    private final int current;
    private Rota previous;
    private double value;

    /**
     * Constructor da Class
     */
    Rota(int current, Rota previous, double value) {
        this.current = current;
        this.previous = previous;
        this.value = value;
    }

    Rota(int current) {
        this.current = current;
        this.previous = null;
        this.value = 0;
    }

    /**
     * Getters e Setters
     */
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

    /**
     * Método que incrementa o custo total do percurso.
     *
     * @param value valor a ser adicionado
     */
    public void incrementValue(double value){
        this.value = this.value+value;
    }

    /**
     * Método que compara duas rotas.
     *
     * @param other rota a ser comparada
     */
    @Override
    public int compareTo(Rota other) { //não sei se o comparador tem de ficar assim ou ao contrario
        return Double.compare(this.value, other.getValue());
    }
}


