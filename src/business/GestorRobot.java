package business;

import business.gConta.Robot;
import business.gLocalizacao.*;
import data.RobotDAO;

import java.util.*;

/*implements Comparable<Robot>*/
public class GestorRobot {
    private Map<Integer, Robot> robotsOcupados;
    private Map<Integer, Robot> robotsDisponiveis;
    private GeradorRota geradorRota;

    public GestorRobot(Mapa mapa) {
        this.robotsOcupados = new HashMap<>();
        this.robotsDisponiveis = RobotDAO.getInstance();
        geradorRota = new GeradorRota(mapa);
    }

    public void desativaRobots() {
        this.robotsDisponiveis.putAll(this.robotsOcupados);
    }

    public Collection<Robot> getRobots() {
        Collection<Robot> result = this.robotsDisponiveis.values();
        result.addAll(this.robotsOcupados.values());
        return result;
    }

    public Map<Integer, Robot> getRobotsDisponiveis() {
        return robotsDisponiveis;
    }
    public void setRobotsDisponiveis(Map<Integer, Robot> robotsDisponiveis) {
        this.robotsDisponiveis = robotsDisponiveis;
    }
    public void addRobot(Robot robot) {
        this.robotsDisponiveis.put(robot.getId(), robot);
    }
    public void addRobot(int localizacao) {
        Set<Integer> ids = this.robotsDisponiveis.keySet();
        ids.addAll(this.robotsOcupados.keySet());
        Robot robot = new Robot(freeKey(ids),localizacao, this.geradorRota.getMapa());
        this.robotsDisponiveis.put(robot.getId(), robot);
    }

    public void addRobot() {
        Set<Integer> ids = this.robotsDisponiveis.keySet();
        ids.addAll(this.robotsOcupados.keySet());
        Robot robot = new Robot(freeKey(ids), 0 , this.geradorRota.getMapa());
        this.robotsDisponiveis.put(robot.getId(), robot);
    }

    // Percorre um set com todas as keys existentes e retorna a key mais pequena disponivel
    public int freeKey (Set<Integer> keyset) {
        int result = 0;
        if(keyset.size() <= 1) return result;
        for(int i = 0; i < keyset.size(); i++){
            if(!keyset.contains(i)){
                return i;
            }
        }
        return keyset.size()+1;
    }

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

    // Escolhe o robot mais perto de uma localizacao e envia-o para essa localizacao
    public int escolheRobot (int to) {
        Rota best = null;
        int robot = -1;
        for (Integer integer : this.robotsDisponiveis.keySet()) {
            Rota novo = this.geradorRota.findBestRout(this.robotsDisponiveis.get(integer).getLocalizacao(), to);
            if (best == null || best.compareTo(novo) < 0) {
                best = novo;
                robot = this.robotsDisponiveis.get(integer).getId();
            }
        }
        // dar este trajeto ao robot e ele executar o trajeto
        if(robot > -1) {
            this.robotsDisponiveis.get(robot).deslocacao(this.geradorRota.getTrajeto(best));
        }
        return robot;
    }

    public void tranportaPatele (int from, int to, int robot) {
        Rota rota = this.geradorRota.findBestRout(from, to);
        this.robotsDisponiveis.get(robot).deslocacao(this.geradorRota.getTrajeto(rota));
    }
}
