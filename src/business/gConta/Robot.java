package business.gConta;

import business.gLocalizacao.Localizacao;

/*implements Comparable<Robot>*/
public class Robot {
    private String id;
    private Localizacao localizacao;

    public Robot(){
        this.id = "";
        this.localizacao = null;
    }

    public Robot(String id, Localizacao localizacao){
        this.id = id;
        this.localizacao = localizacao;
    }

    public String getId() { return this.id; }
    public void setId(String id) {
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
