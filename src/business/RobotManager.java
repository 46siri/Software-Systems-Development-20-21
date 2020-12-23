package business;

import business.gConta.Robot;
import business.gLocalizacao.GeradorRota;
import business.gLocalizacao.Localizacao;
import business.gLocalizacao.Mapa;
import business.gLocalizacao.Rota;

import java.util.*;

/*implements Comparable<Robot>*/
public class RobotManager {
    private Map<Integer, Robot> robotsOcupados;
    private Map<Integer, Robot> robotsDisponiveis;
    private GeradorRota geradorRota;

    public RobotManager(){
        this.robotsDisponiveis = null;
        this.robotsOcupados = null;
        this.geradorRota = null;
    }
    public RobotManager(Mapa<Localizacao> mapa) {
        this.robotsOcupados = new HashMap<>();
        this.robotsDisponiveis = new HashMap<>();
        geradorRota = new GeradorRota(mapa);
    }


    public Map<Integer, Robot> getRobotsOcupados() {
        return robotsOcupados;
    }

    public Map<Integer, Robot> getRobotsDisponiveis() {
        return robotsDisponiveis;
    }
    public void setRobotsDisponiveis(Map<Integer, Robot> robotsDisponiveis) {
        this.robotsDisponiveis = robotsDisponiveis;
    }
  /*  public void addRobot(Robot robot) {
        this.robotsDisponiveis.put(robot.getId(), robot);
    }*/

    public void removeRobot(int id) {
        this.robotsDisponiveis.remove(id);
        this.robotsOcupados.remove(id);
    }

    public void reserveRobot (int idRobot) {
        this.robotsOcupados.put(idRobot, this.robotsDisponiveis.remove(idRobot));
    }
    public void freeRobot (int idRobot) {
        this.robotsDisponiveis.put(idRobot, this.robotsOcupados.remove(idRobot));
    }

    public void escolheRobot (Localizacao to) {
        Rota best = null;
        String robot;
        for (Integer integer : this.robotsDisponiveis.keySet()) {
            Rota novo = this.geradorRota.findBestRout(this.robotsDisponiveis.get(integer).getLocalizacao(), to);
            if (best == null || best.compareTo(novo) < 0) {
                best = novo;
                robot = this.robotsDisponiveis.get(integer).getId();
            }
        }
        this.geradorRota.getTrajeto(best);
        // falta dar este trajeto ao robot e ele executar o trajeto
    }

    //alterar localização da palete - em robot
    public void notificaRecolha(){

    }

    //alterar localização da palete - em preteleira
    public void notificaEntrega(){

    }

    private void getRobot(int id_robot) {

    }
}
