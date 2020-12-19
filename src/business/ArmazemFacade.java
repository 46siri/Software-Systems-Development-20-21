package business;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArmazemFacade {

    private Map<String, Robot> robots;
    private Map<String, Gestor> gestores;
    private Map<String, Palete> paletes;


    //ROBOTS
    /**
     * Método que devolve todos os alunos registados.
     *
     * @return todos os robots registados
     */
    public Collection<Robot> getRobots() {
        return new ArrayList<>(this.robots.values());
    }

    /**
     * @param rid id do robot a procurar
     * @return true se o robot existe
     */
    public boolean existeRobot(String rid){return this.robots.containsKey(rid);}

    /**
     * @param r robot a dicionar
     */
    public void adicionaRobot(Robot r){this.robots.put(r.getId(),r);}

    /**
     * @param id do robota procurar
     * @return true se o robot existe
     */
    public Robot procuraRobot(String id) { return this.robots.get(id); }

    /**
     * Método que remove um robot do armazem
     *
     * @param rid id do robot
     */
    public void removeRobot(String rid) {
        Robot r = this.robots.get(rid);
        r.removeRobot(rid);
        this.robots.put(rid, r);  // Necessário fazer put para actualizar a BD.
    }


    //GESTOR

    /**
     * Método que devolve todos os gestores registados.
     *
     * @return todos os gestores registados
     */
    public Collection<Gestor> getGestores() {
        return new ArrayList<>(this.gestores.values());
    }

    /**
     * @param username username do gestor a procurar
     * @return true se o gestor existe
     */
    public boolean existeGestor(String username){return this.gestores.containsKey(username);}

    /**
     * @param g gestor a dicionar
     */
    public void adicionaGestor(Gestor g){this.gestores.put(g.getUserName(),g);}

    /**
     * @param username do gestor a procurar
     * @return true se o gestor existe
     */
    public Gestor procuraGestor(String username) { return this.gestores.get(username); }

    /**
     * Método que remove um gestor do armazem
     *
     * @param username username do gestor
     */
    public void removeGestor(String username) {
        Gestor g = this.gestores.get(username);
        g.removeGestor(username);
        this.gestores.put(username, g);  // Necessário fazer put para actualizar a BD.
    }

    /**
     * @param p palete a dicionar
     */
    public void adicionaPalete(Palete p){this.paletes.put(p.getId(),p);}

    /**
     * @param id username da palete a procurar
     * @return true se a palete existe
     */
    public boolean existePalete(String id){return this.paletes.containsKey(id);}

    public void  armazenarPalete(String id){
        //
    }

    public boolean passwordCerta(String username, String password) {
        Gestor g = procuraGestor(username);
        return !g.getPassword().equals(password);
    }

    public void listarLocalizacoes() {
    }
}