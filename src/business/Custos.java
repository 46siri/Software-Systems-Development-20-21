package business;

public interface Custos<L extends Localizacao> {
    double computeCost(L from, L to);
}
