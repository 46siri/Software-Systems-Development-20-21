package business.gConta;

import business.gLocalizacao.Mapa;

import java.util.Stack;

/*implements Comparable<Robot>*/
public class Robot {
    private int id;
    private int localizacao;
    private Mapa mapa;

    public Robot(int id, int localizacao, Mapa mapa){
        this.id = id;
        this.localizacao = localizacao;
        this.mapa = mapa;
    }

    public int getId() { return this.id; }
    public void setId(int id) {
        this.id = id;
    }

    public int getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    //alterar localização da palete - em robot
    public void notificaRecolha(){

    }

    // o robot vai receber um arraylist com localizacoes e vai para eles uma por uma
    public void deslocacao(Stack<Integer> percurso) {
        while (!percurso.isEmpty()) {
            //o robot só recebe a nova localizacao uma de cada vez
            this.localizacao = percurso.pop();
        }
    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){
    }
}
