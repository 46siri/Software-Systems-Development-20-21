package business;

import business.*;
import java.util.Collection;
import java.util.TreeSet;
/*implements Comparable<Robot>*/
public class Robot {
    private int id;
    private boolean estadoLivre;
    private Collection<String> lstRobots;

    public Robot() {
        this.id = -1 ;
        this.estadoLivre= true;
        this.lstRobots = new TreeSet<>();
    }

    public Robot(int id, boolean estado){
        this.id = id;
        this.estadoLivre = estado;
    }
    /**
     * Método get para o Id do robot.
     * @return Valor do id do robot.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Método set para o id do robot.
     */
    public void setID(int id){
        this.id = id;
    }

    /**
     * Método que verifica se dois funcionarios são iguais
     * @param o objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o.getClass() != this.getClass()) return false;

        Robot temp = (Robot)o;

        return this.id == temp.getId();
    }

    public void removeRobot(String id){this.lstRobots.remove(id);}

    //alterar localização da palete - em robot
    public void notificaRecolha(){

    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){

    }

    private void getRobot(int id_robot) {
    }

    public void setEstado(boolean estado){ this.estadoLivre = estado; }
/*
    @Override
    public int compareTo(Robot o) {
        return this.id.compareTo(o.getId());
    }*/


}
