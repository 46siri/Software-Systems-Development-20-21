package business;

import business.gArmazem.Palete;
import business.gArmazem.Prateleira;
import business.gConta.Gestor;
import business.gConta.Robot;

import java.util.Collection;

/**
 * API da Facade da lógica de negócio.
 *
 * @author grupo09
 * @version 202012
 */
public interface IArmazemFacade{
    void closeSystem();
    Collection<Robot> getRobots();
    void adicionaRobot();
    String getAllRobots();
    void removeRobot(int id);
    void alteraGestor (String userName,String password, String nome, String email);
    Collection<Gestor> getGestores();
    boolean existeGestor(String username);
    void adicionaGestor(Gestor g);
    Gestor procuraGestor(String username);
    void removeGestor(String username);
    void adicionaPalete(Palete p);
    boolean existePalete(String id);
    void  armazenarPalete(String id);
    boolean passwordCerta(String username, String password);
    Collection<Prateleira> getPrateleiras();
}
