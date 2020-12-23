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

    public Robot(int id, Localizacao localizacao){
        this.id = id;
        this.localizacao = localizacao;
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
    public void deslocacao(Stack<Localizacao> percurso) throws InterruptedException {
        while (!percurso.isEmpty()) {
            Localizacao next = percurso.pop();
            wait((long) mapa.getDistance(this.localizacao, next)) ;
            this.localizacao = next;
        }
    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){
    }

    private void getRobot(int id_robot) {
    }
}
