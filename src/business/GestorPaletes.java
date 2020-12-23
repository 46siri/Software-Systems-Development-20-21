package business;

import business.gArmazem.Palete;
import data.PaleteDAO;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GestorPaletes {
    private Queue<String> paleteQueue; //Paletes em espera de prateleira
    private Map<String, Palete> paletes; //Paletes na prateleira

    /**
     * Constructor da Class.
     */
    public GestorPaletes() {
        this.paletes = PaleteDAO.getInstance();
        this.paleteQueue = new LinkedList<>();
    }

    /**
     * Getters and Settters
     */
    public Map<String, Palete> getPaletes() { return paletes; }
    public void setPaletes(Map<String, Palete> paletes) { this.paletes = paletes; }

    public Queue<String> getPaleteQueue() { return paleteQueue; }
    public void setPaleteQueue(Queue<String> paleteQueue) { this.paleteQueue = paleteQueue; }

    /**
     * Método que adiciona uma palete acabada de entrar no armazem.
     */
    public void adicionaPalete(Palete p){
        this.paletes.put(p.getId(),p);
        this.paleteQueue.add(p.getId());
    }

    /**
     * Método que verifica se uma palete existe.
     */
    public boolean existePalete(String id){return this.paletes.containsKey(id);}

    /**
     * Método que obtem a lozalizacao de uma palete.
     *
     * @param id identificador da palete
     * @return Localizacao da palete
     */
    public int getLocalizacaoPalete(String id) {
        return this.paletes.get(id).getLocalizacao();
    }

    /**
     * Método que altera a localizacao de uma palete.
     *
     * @param id identificador da palete
     * @param localizacao destino da palete
     */
    public void movePalete(String id, int localizacao){
        this.paletes.get(id).setLocalizacao(localizacao);
    }
}
