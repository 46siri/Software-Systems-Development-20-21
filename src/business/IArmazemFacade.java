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
        Collection<Robot> getRobots(String id);
        boolean existeRobot(String rid);
        void adicionaRobot(Robot r);
        void removeRobot(String rid);
        void alteraRobot(String rid, Boolean estado);
        void registaRobot(String rid, Boolean estado);
        Collection<Gestor> getGestores(String userName);
        void registaGestor(String userName, String password,String nome, String email);
        void alteraGestor (String userName,String password, String nome, String email);
        boolean existeGestor(String username);
        void adicionaGestor(Gestor g);
        Gestor procuraGestor(String username);
        void removeGestor(String username);
        void adicionaPalete(Palete p);
        boolean existePalete(String id);
        void  armazenarPalete(String id);
        boolean passwordCerta(String username, String password);
        Collection<Prateleira> listarLocalizacoes();
}
