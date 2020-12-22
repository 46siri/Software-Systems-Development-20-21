package business;

import java.util.*;

/*implements Comparable<Robot>*/
public class RobotManager {
    private Map<Integer, Robot> robotsMap;
    private Collection<Integer> robotsDisponiveis;

    public RobotManager() {
        this.robotsMap = new HashMap<>();
        this.robotsOcupados = new HashMap<>();
    }


    //public void removeRobot(int id){this.lstRobots.remove(id);}

    //alterar localização da palete - em robot
    public void notificaRecolha(){

    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){

    }

    private void getRobot(int id_robot) {

    }
/*
    @Override
    public int compareTo(Robot o) {
        return this.id.compareTo(o.getId());
    }*/


}
