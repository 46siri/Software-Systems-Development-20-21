package business;

import java.util.ArrayList;

public class gArmazem {
    private ArrayList<Palete> paletes = new ArrayList<Palete>();

    public ArrayList<Palete> addPaleteQueue(String id_palete){
        return null;
    }


    //quando chega nova palete - sistema rtem de notificar rbot
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
        return null;
    }

    public void addPaleteAguardaTrasnporte(String id_Palete){

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

}
