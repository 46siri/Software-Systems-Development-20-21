package business;

import business.gConta.Robot;
import business.gLocalizacao.*;
import data.RobotDAO;

import java.util.*;

/*implements Comparable<Robot>*/
public class GestorRobot {
    /**
     * @param robotsOcupados Mapa dos robots ocupados
     */
    private Map<Integer, Robot> robotsOcupados;
    /**
     * @param robotsOcupados Mapa dos robots disponiveis
     */
    private Map<Integer, Robot> robotsDisponiveis;
    private GeradorRota geradorRota;

    /**
     * Constructor da Class.
     */
    public GestorRobot(Mapa mapa) {
        this.robotsOcupados = new HashMap<>();
        this.robotsDisponiveis = RobotDAO.getInstance();
        geradorRota = new GeradorRota(mapa);
    }

    /**
     * Método que coloca todos os robots no Map de robots disponiveis.
     */
    public void desativaRobots() {
        this.robotsDisponiveis.putAll(this.robotsOcupados);
    }

    /**
     * Método que cria um collection com todos os robots.
     *
     * @return Collection com todos os robots
     */
    public Collection<Robot> getRobots() {
        Collection<Robot> result = this.robotsDisponiveis.values();
        result.addAll(this.robotsOcupados.values());
        return result;
    }

    /**
     * Getters e Setters.
     */
    public Map<Integer, Robot> getRobotsDisponiveis() {
        return robotsDisponiveis;
    }
    public void setRobotsDisponiveis(Map<Integer, Robot> robotsDisponiveis) {
        this.robotsDisponiveis = robotsDisponiveis;
    }

    /**
     * Metodo que adiciona um robot á lista de robots disponiveis.
     *
     * @param robot robot a ser adicionado á lista de robots
     */
    public void addRobot(Robot robot) {
        this.robotsDisponiveis.put(robot.getId(), robot);
    }

    /**
     * Metodo que adiciona um robot á lista de robots disponiveis.
     *
     * Cria o robot usando um id disponivel
     * @param localizacao localizacao do robot a ser adicionado
     */
    public void addRobot(int localizacao) {
        Set<Integer> ids = this.robotsDisponiveis.keySet();
        ids.addAll(this.robotsOcupados.keySet());
        Robot robot = new Robot(freeKey(ids),localizacao, this.geradorRota.getMapa());
        this.robotsDisponiveis.put(robot.getId(), robot);
    }

    /**
     * Metodo que adiciona um robot á lista de robots disponiveis.
     *
     * Cria o robot usando um id disponivel
     * Cria o robot usando a localizacao 0
     */
    public void addRobot() {
        Set<Integer> ids = this.robotsDisponiveis.keySet();
        ids.addAll(this.robotsOcupados.keySet());
        Robot robot = new Robot(freeKey(ids), 0 , this.geradorRota.getMapa());
        this.robotsDisponiveis.put(robot.getId(), robot);
    }

    /**
     * Método que percorre um Keyset e retorna a key livre mais pequena.
     *
     * @param keyset Keyset dos robots disponiveis e ocupados
     * @return id livre mais baixo
     */
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

    /**
     * Método que remove um robot.
     *
     * @param id identificador do robot
     */
    public void removeRobot(int id) {
        this.robotsDisponiveis.remove(id);
        this.robotsOcupados.remove(id);
    }

    /**
     * Método que remove um robot do Map de robots livres e coloca no Map de robots ocupados.
     *
     * @param idRobot identificador do robot
     */
    public void reserveRobot (int idRobot) {
        this.robotsOcupados.put(idRobot, this.robotsDisponiveis.remove(idRobot));
    }

    /**
     * Método que remove um robot do Map de robots ocupados e coloca no Map de robots disponiveis.
     *
     * @param idRobot identificador do robot
     */
    public void freeRobot (int idRobot) {
        this.robotsDisponiveis.put(idRobot, this.robotsOcupados.remove(idRobot));
    }

    /**
     * Método que escolhe o robot mais perto de uma localizacao e envia-o para essa localizacao.
     *
     * @param to localizacao destino do robot
     * @return robot escolhido para fazer o percurso
     */
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
        if(robot > -1) {
            this.robotsDisponiveis.get(robot).deslocacao(this.geradorRota.getTrajeto(best));
        }
        return robot;
    }

    /**
     * Método que simula o transporte de uma palete.
     *
     * Este metodo gera uma rota desde a localizacao da palete ate a localizacao da prateleira e envia-a ao robot
     *
     * @param from localizacao origem do robot
     * @param to localizacao destino do robot
     * @param robot identificador do robot
     */
    public void tranportaPatele (int from, int to, int robot) {
        Rota rota = this.geradorRota.findBestRout(from, to);
        this.robotsDisponiveis.get(robot).deslocacao(this.geradorRota.getTrajeto(rota));
    }
}
