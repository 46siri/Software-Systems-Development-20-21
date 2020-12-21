package business;

import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class Localizacao {
    private char zona;
    private char seccao;
    private char prateleira;

    public Localizacao() {
        this.zona = ' '; // A-descarga  B-prateleiras C
        this.seccao = ' ';
        this.prateleira = ' ';
    }

    public Localizacao(char zona, char seccao, char prateleira){
        this.zona = zona;
        this.seccao = seccao;
        this.prateleira = prateleira;
    }

    public void toLocalizacao(String local){
        this.zona = local.charAt(0);
        this.seccao = local.charAt(1);
        this.prateleira = local.charAt(2);
    }

    @Override
    public String toString(){return "Localização:" +this.zona + this.seccao + this.zona; }
}
