package business;

import java.util.Collection;
import java.util.TreeSet;

public class Localizacao {
    private char zona;
    private int seccao;
    private int prateleira;

    public Localizacao() {
        this.zona = 'A';
        this.seccao = 0;
        this.prateleira = 0;
    }

    public Localizacao(char zona, int seccao, int prateleira){
        this.zona = zona;
        this.seccao = seccao;
        this.prateleira = prateleira;
    }

    @Override
    public String toString(){return "Localização(" + ")"; }
}
