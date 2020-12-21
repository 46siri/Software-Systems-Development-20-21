/*package business;
import java.util.*;

import data.DescargaDAO;
import data.PaleteDao;

public class Armazem {
    private PaleteDao paleteDAO;
    private DescargaDAO descargaDAO;
    private PedidoDAO requisicaoDAO;

    **
     * Contrutor sem parametros da classe Armazem.
     *

    public Armazem(){
        this.paleteDAO = new PaleteDao();
        this.descargaDAO = new DescargaDAO();
        this.requisicaoDAO = new PedidoDAO();
    }
    **
     * Método para obter uma lista com as paletes existentes no armazém.
     * @return Lista com as paletes.
     *

    public List<Palete> getPaleteList() throws Exception{
        return this.paleteDAO.list();
    }

    **
     * Método para verificar uma dada palete já se encontra no sistema.
     * @param cod Chave da palete a procurar.
     * @return Boolean que representa a existência de um elemento no sistema.
     *
    public boolean existePalete(int cod){
        return this.paleteDAO.containsKey(cod);
    }

    *
    public ArrayList<Palete> addPaleteQueue(String id_palete){
        return null;
    }


    quando chega nova palete - sistema rtem de notificar rbot
    public void criaNovaPalete(String paleteS){

    }

    public String getLocalizacoes(){
        //get todas as localizações e passar para String
        return  null;
    }

    public void removeQueueList(String id_Palete){

    }

    public Prateleira getPrateleiraLivre(){
        return null;
    }

    public String getRobotLivre(){
        return null;
    }

    public Rota calculaRota(Localizacao inicio, Localizacao fim){
        return null;0
    }

    public void addPaleteAguardaTrasnporte(int id) throws ClassNotFoundException,SQLException{
        Palete p = new Palete(id,0);
    }

    public Rota getRota(){
        return null;
    }

    public void removePaleteAguardaTrasnporte(String id_Palete){

    }

    public void setRobotLivre(Robot robot, String id_robot){
        robot.setEstado(false);
    }

    public void adicionaPalete(){

    }

}*/
