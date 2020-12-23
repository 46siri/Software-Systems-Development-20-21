package business;


import business.gArmazem.Palete;
import business.gArmazem.Prateleira;
import business.gConta.Gestor;
import business.gConta.Robot;
import data.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArmazemFacade implements IArmazemFacade {

    private Map<String, Robot> robots;
    private Map<String, Gestor> gestores;
    private Map<String, Palete> paletes;
    private Collection<String> lstGestores;

    public ArmazemFacade(){
        this.robots = RobotDAO.getInstance();
        this.gestores = GestorDAO.getInstance();
        this.paletes = PaleteDAO.getInstance();
    }
    //ROBOTS
    /**
     * Método que devolve todos os robots registados.
     *
     * @return todos os robots registados
     */
    @Override
    public Collection<Robot> getRobots() {
        return new ArrayList<>(this.robots.values());
    }

    /**
     * @param rid id do robot a procurar
     * @return true se o robot existe
     */
    @Override
    public boolean existeRobot(String rid){return robots.containsKey(rid);}

    /**
     * @param r robot a dicionar
     */
    public void adicionaRobot(Robot r){this.robots.put(r.getId(),r);}

    @Override
    public void removeRobot(String rid) {

    }

    @Override
    public void alteraRobot(String rid, Boolean estado) {

    }

    @Override
    public void registaRobot(String rid, Boolean estado) {

    }

    @Override
    public Collection<Gestor> getGestores(String userName) {
        return null;
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
        this.lstGestores.add(g.getUserName());
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
        this.lstGestores.remove(username);
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


    /**
     * @param p palete a dicionar
     */
    @Override
    public void adicionaPalete(Palete p){this.paletes.put(p.getId(),p);}



    /**
     * @param id username da palete a procurar
     * @return true se a palete existe
     */
    @Override
    public boolean existePalete(String id){return this.paletes.containsKey(id);}

    @Override
    public void  armazenarPalete(String id){
        return;
    }

    @Override
    public boolean passwordCerta(String username, String password) {
        Gestor g = procuraGestor(username);
        return !g.getPassword().equals(password);
    }

    @Override
    public void listarLocalizacoes() {

    }
}