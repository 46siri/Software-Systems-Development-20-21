package business.gConta;

import business.gLocalizacao.Localizacao;
import business.gLocalizacao.Mapa;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Stack;
import java.util.TreeSet;
/*implements Comparable<Robot>*/
public class Robot {
    private int id;
    private Localizacao localizacao;
    private Mapa mapa;

    public Robot(int id, Localizacao localizacao, Mapa mapa){
        this.id = id;
        this.localizacao = localizacao;
        this.mapa = mapa;
    }

    public int getId() { return this.id; }
    public void setId(int id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    //alterar localização da palete - em robot
    public void notificaRecolha(){

    }

    // o robot vai receber um arraylist com localizacoes e vai para eles uma por uma
    public void deslocacao(Stack<Localizacao> percurso) {
        while (!percurso.isEmpty()) {
            //o robot só recebe a nova localizacao uma de cada vez
            this.localizacao = percurso.pop();
        }
    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){
    }
}
