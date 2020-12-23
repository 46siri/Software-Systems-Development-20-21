package business;


import business.gArmazem.Palete;
import business.gArmazem.Prateleira;
import business.gConta.Gestor;
import business.gConta.Robot;
import business.gLocalizacao.Mapa;
import data.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ArmazemFacade implements IArmazemFacade {

    private GestorRobot robots;
    private Map<String, Gestor> gestores;
    private GestorPaletes paletes;
    private Map<String, Prateleira> prateleiras;

    public ArmazemFacade(){
        this.robots = new GestorRobot(new Mapa());
        this.gestores = GestorDAO.getInstance();
        this.paletes = new GestorPaletes();
        this.prateleiras = PrateleiraDAO.getInstance();
    }

    @Override
    public void closeSystem(){
        robots.desativaRobots();
    }
    //ROBOTS
    /**
     * Método que devolve todos os robots registados.
     *
     * @return todos os robots registados
     */
    @Override
    public Collection<Robot> getRobots() {
        return this.robots.getRobots();
    }

    @Override
    public String getAllRobots() {
        return this.robots.getRobots().toString();
    }

    /**
     *  cria robot e diciona
     */
    public void adicionaRobot(){this.robots.addRobot();}

    @Override
    public void removeRobot(int id) {
        this.robots.removeRobot(id);
    }

    @Override
    public void alteraRobot(int id, Boolean estado) {

    }

    @Override
    public void registaRobot(int id, Boolean estado) {

    }

    @Override
    public void registaGestor(String userName, String password, String nome, String email) {

    }

    //GESTOR

    /**
     * Método que devolve todos os gestores registados.
     *
     * @return todos os gestores registados
     */
    @Override
    public Collection<Gestor> getGestores() {
        return new ArrayList<>(this.gestores.values());
    }

    /**
     * @param username username do gestor a procurar
     * @return true se o gestor existe
     */
    @Override
    public boolean existeGestor(String username){return this.gestores.containsKey(username);}

    /**
     * @param g gestor a dicionar
     */
    @Override
    public void adicionaGestor(Gestor g){
        this.gestores.put(g.getUserName(),g);
    }

    /**
     * @param username do gestor a procurar
     * @return true se o gestor existe
     */
    @Override
    public Gestor procuraGestor(String username) { return this.gestores.get(username); }


    /**
     * Método que remove um gestor do armazem
     *
     * @param username username do gestor
     */
    @Override
    public void removeGestor(String username) {
        Gestor g = this.gestores.get(username);
        this.gestores.put(username, g);  // Necessário fazer put para actualizar a BD.
    }


    /**
     * Método que altera um gestor do armazem
     *
     * @param userName userName do gestor
     */
    public void alteraGestor (String userName,String password, String nome, String email){
        Gestor g = new Gestor(userName, password ,nome, email);
        this.gestores.put(userName,g);
    }

    // Paletes
    /**
     * @param p palete a dicionar
     */
    @Override
    public void adicionaPalete(Palete p){this.paletes.adicionaPalete(p);}

    /**
     * @param id username da palete a procurar
     * @return true se a palete existe
     */
    @Override
    public boolean existePalete(String id){return this.paletes.existePalete(id);}

    @Override
    public void armazenarPalete(String id){
        int to = this.getPrateleiraLivre();
        int from = this.paletes.getLocalizacaoPalete(id);
        int robot = this.robots.escolheRobot(from);
        this.robots.tranportaPatele(from, to, robot);
        this.paletes.movePalete(id, to);
    }

    public int getPrateleiraLivre(){
        int result = -1;
        for (Prateleira prateleira : this.prateleiras.values()) {
            if(prateleira.getEstado()){
                prateleira.setEstadoLivre(false);
                result = prateleira.getLocalizacao();
                break;
            }
        }
        return result;
    }

    @Override
    public boolean passwordCerta(String username, String password) {
        Gestor g = procuraGestor(username);
        return !g.getPassword().equals(password);
    }

    @Override
    public Collection<Prateleira> getPrateleiras() {
        return new ArrayList<>(this.prateleiras.values());
    }

}