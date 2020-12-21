package business;
import business.Localizacao;
import business.Palete;

public class Requisicao {
    private int id;
    private int robot;
    private int servidorProd;
    private boolean status;
    private Palete palete;

    /**
     * Método get para o id de uma requisicao.
     *
     * @return
     */
    public int getID() {
        return this.id;
    }

    /**
     * Método set para o id de uma requisicao.
     *
     * @param id
     */

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Método get para o servidor de produção que fez a encomenda.
     *
     * @return Identificador do servidor de produção.
     */

    public int getServidorProd() {
        return this.servidorProd;
    }

    /**
     * Método set para o servidor de produção que fez a encomenda.
     *
     * @param servidorProd Id do servidor de produção.
     */

    public void setServidorProd(int cliente) {
        this.servidorProd = servidorProd;
    }
    /**
     * Método get para o robot que fez a recolha.
     * @return Identificador do robot.
     */

    public int getRobot() {
        return this.robot;
    }

    /**
     * Método set para o robot que fez a recolha.
     * @param robot Id do robot.
     */

    public void setRobot(int robot) {
        this.robot = robot;
    }
    /**
     * Método get para a palete presente na requisicao.
     * @return Palete da requisicao.
     */

    public Palete getPalete() {
        return this.palete;
    }
    /**
     * Método set para a palete presente na requisicao.
     * @param palete palete a inserir na requisicao.
     */

    public void setPalete(Palete palete) {
        this.palete = palete;
    }
    /**
     * Método get para o estado da requisicao.
     * @return Valor do estado da requisicao.
     */

    public boolean getStatus(){
        return this.status;
    }/**
     * Método set para o estado da requisicao.
     * @param status
     */

    public void setStatus(boolean status){
        this.status = status;
    }
}/**
 * Método get para a localização de uma palete.
 * @return Lista com as localizações.
 */

public List<Localizacao> getLocalizacao(){
    return this.palete.getLocalização();
}
    /**
     * Construtor parameterizado de uma requisicao.
     * @param id Id da requisicao.
     * @param servidorProd Id do servidor de producao da requisicao.
     * @param robot Id do robot da requisicao.
     * @param palete Palete pedida na requisicao.
     */

    public Requisicao(int id, int servidorProd, int robot, Palete palete) {
        this.id = id;
        this.servidorProd = servidorProd;
        this.status = false;
        this.robot = robot;
        this.palete = palete;
    }

