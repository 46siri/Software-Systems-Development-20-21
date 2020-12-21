package business;

import java.util.Collection;

/**
 * API da Facade da lógica de negócio.
 *
 * @author grupo09
 * @version 202012
 */
public interface IArmazemFacade{
        Collection<Robot> getRobots();

        /**
         * Método que verifica se um robot existe
         *
         * @param rid id do robot a procurar
         * @return true se o robot existe
         */
        boolean existeRobot(String rid);

        void adicionaRobot(Robot r);

        void removeRobot(String rid);

        Collection<Gestor> getGestores();

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
