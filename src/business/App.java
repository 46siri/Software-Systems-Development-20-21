package business;
import data.*;
import business.*;
import java.sql.SQLException;
import java.util.*;

public class App {
    public Armazem armazem;
    public PaleteDao paleteDao;
    public DescargaDAO descargaDAO;
    public PedidoDAO pedidoDAO;
    public ServidorProdDAO servidorProdDAO;

    public App(){
        this.armazem = new Armazem();
        this.paleteDao = new PaleteDao();
        this.pedidoDAO = new PedidoDAO();
        this.descargaDAO = new DescargaDAO();
    }
    /**
     * Método para fazer log in na aplicação.
     * @param id Identificador do utilizador.
     * @param password Password corresponde.
     * @return Permissões dadas
     */


    public int logIn(int id, String password) {
        if (id == 0 && password.equals("admin")) return 3;

        int r = -1;

        try {
            Gestor g = this.gestorDAO.get(id);
            r = g.authenticate(password);
        } catch (Exception e) {
            r = -1;
        }

        return r;
    }

    /**
     * Método para obter uma lista com todos os componentes que o sistema tem.
     * @return Lista com todos os componentes do sistema.
     * @throws Exception
     */


    public List<Palete> getPalete() throws Exception {
        return this.paleteDao.list();
    }
    /**
     * Método para devolver todas as descargas até ao momento.
     *
     * @return Coleção com todas as descargas.
     */


    public List<Descarga> getDescarga() throws Exception {
        return this.armazem.getDescarga();
    }
    /**
     * Método para devolver todas as requisições até ao momento.
     *
     * @return Coleção com todas as requisições.
     */


    public List<Requisicao> getRequisicao() throws Exception {
        return this.armazem.getRequisicao();
    }
    /**
     * Método para devolver um Map com o stock atual das paletes.
     *
     * @return Map com o stock das paletes.
     */

    public Map<String,Palete> getPaleteList() {
        List<Palete> aux;
        try {
            aux = this.armazem.getPaleteList();
        } catch (Exception e) {
            aux = new ArrayList<>();
        }

        Map<String, Palete> res = new HashMap<>();

        for(Palete k : aux){
            try{
                int id = k.getId();
                Componente c = this.componenteDAO.get(id);
                res.put(c.getDesignacao(), k);
            }
            catch (Exception e){}
        }
        return res;
    }

    /**
     * Método para verificar uma dada palete já se encontra no sistema.
     *
     * @param cod Chave da palete a procurar.
     * @return Boolean que representa a existência de um elemento no sistema.
     */

    public boolean existePalete(int cod) {
        return this.armazem.existePalete(cod);
    }

}
