package business.gConta;

import business.gLocalizacao.Localizacao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.TreeSet;
/*implements Comparable<Robot>*/
public class Robot {
    private int id;
    private Localizacao localizacao;

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
    public void deslocacao(){

    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){
    }

    private void getRobot(int id_robot) {
    }
}
