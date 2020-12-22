package business;


import data.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArmazemFacade implements IArmazemFacade {

    private Map<String, Robot> robots;
    private Map<String, Gestor> gestores;
    private Map<String, Palete> paletes;
    private Map<String, Prateleira> prateleiras;


    public ArmazemFacade(){
        this.robots = RobotDAO.getInstance();
        this.gestores = GestorDAO.getInstance();
        this.paletes = PaleteDAO.getInstance();
        this.prateleiras = (Map<String, Prateleira>) PrateleiraDAO.getInstance();
    }
    //ROBOTS
    /**
     * Método que devolve todos os robots registados.
     *
     * @return todos os robots registados
     * @param id
     */
    @Override
    public Collection<Robot> getRobots(String id) {
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

    /**
     * Método que remove um robot do armazem
     *
     * @param rid id do robot
     */
    @Override
    public void removeRobot(String rid) {
        Robot r = this.robots.get(rid);
        r.removeRobot(rid);
        this.robots.put(rid, r);  // Necessário fazer put para actualizar a BD.
    }



    /**
     * Método que altera um robot do armazem
     *
     * @param rid id do robot
     */
    public void alteraRobot (String rid, Boolean estado){
        Robot r = new Robot(rid, estado);
        this.robots.put(rid,r);
    }

    public void registaRobot(String rid, Boolean estado)throws SQLException, ClassNotFoundException{
        Robot r;
        r = new Robot(rid, estado);
        this.robots.put(rid, r);
    }

    //GESTOR

    /**
     * Método que devolve todos os gestores registados.
     *
     * @return todos os gestores registados
     */
    @Override
    public Collection<Gestor> getGestores(String userName) {
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
    public void adicionaGestor(Gestor g){this.gestores.put(g.getUserName(),g);}

    /**
     * @param username do gestor a procurar
     * @return true se o gestor existe
     */
    @Override
    public Gestor procuraGestor(String username) { return this.gestores.get(username); }
    /**
     * Método para registar um gestor no sistema.
     * @param nome Nome do gestor.
     * @param userName user name do gestor.
     * @param email Email do gestor.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void registaGestor(String userName,String nome, String email) throws SQLException, ClassNotFoundException{
        Gestor g ;
        g = new Gestor(userName, nome, email);
        this.gestores.put(userName, g);
    }
    /**
     * Método que remove um gestor do armazem
     *
     * @param username username do gestor
     */
    @Override
    public void removeGestor(String username) {
        Gestor g = this.gestores.get(username);
        g.removeGestor(username);
        this.gestores.put(username, g);  // Necessário fazer put para actualizar a BD.
    }
    /**
     * Método que altera um gestor do armazem
     *
     * @param userName userName do gestor
     */
    public void alteraGestor (String userName, String nome, String email){
        Gestor g = new Gestor(userName, nome, email);
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
    public Collection<Prateleira> listarLocalizacoes() {
        return new ArrayList<>(this.prateleiras.values());
    }

    public Object getRobots(int id) {
        return null;
    }

    public void alteraRobot(String id) {
    }
}