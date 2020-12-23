package business;

import business.gArmazem.Palete;
import data.PaleteDAO;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GestorPaletes {
    private Queue<String> paleteQueue; //Paletes em espera de prateleira
    private Map<String, Palete> paletes; //Paletes na prateleira

    public GestorPaletes() {
        this.paletes = PaleteDAO.getInstance();
        this.paleteQueue = new LinkedList<>();
    }

    public GestorPaletes(Map<String, Palete> paletes, Queue<String> paleteQueue) {
        this.paletes = paletes;
        this.paleteQueue = paleteQueue;
    }

    public Map<String, Palete> getPaletes() { return paletes; }
    public void setPaletes(Map<String, Palete> paletes) { this.paletes = paletes; }

    public Queue<String> getPaleteQueue() { return paleteQueue; }
    public void setPaleteQueue(Queue<String> paleteQueue) { this.paleteQueue = paleteQueue; }

    public void adicionaPalete(Palete p){
        this.paletes.put(p.getId(),p);
        this.paleteQueue.add(p.getId());
    }

    public boolean existePalete(String id){return this.paletes.containsKey(id);}

    public int getLocalizacaoPalete(String id) {
        return this.paletes.get(id).getLocalizacao();
    }

    public void movePalete(String id, int localizacao){
        this.paletes.get(id).setLocalizacao(localizacao);
    }
}
