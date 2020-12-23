package business.gConta;

import business.gLocalizacao.Mapa;

import java.util.Stack;

/*implements Comparable<Robot>*/
public class Robot {
    private int id;
    private int localizacao;
    private Mapa mapa;

    /**
     * Constructor da Class
     */
    public Robot(int id, int localizacao, Mapa mapa){
        this.id = id;
        this.localizacao = localizacao;
        this.mapa = mapa;
    }

    /**
     * Getters e Setters
     */
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

    /**
     * Método que simula a deslocacao do robot pelas diferente localizacoes.
     *
     * @param percurso Stack com o percurso
     */
    public void deslocacao(Stack<Integer> percurso) {
        while (!percurso.isEmpty()) {
            //o robot só recebe a nova localizacao uma de cada vez
            this.localizacao = percurso.pop();
        }
    }

}
