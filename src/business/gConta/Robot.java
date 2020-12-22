package business.gConta;

import java.util.Collection;
import java.util.TreeSet;
/*implements Comparable<Robot>*/
public class Robot {
    private String id;
    private boolean estadoLivre;
    private Collection<String> lstRobots;

    public Robot() {
        this.id = "" ;
        this.estadoLivre= true;
        this.lstRobots = new TreeSet<>();
    }

    public Robot(String id, boolean estado){
        this.id = id;
        this.estadoLivre = estado;
    }

    public String getId() { return this.id; }

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
