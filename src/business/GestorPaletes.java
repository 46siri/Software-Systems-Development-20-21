package business;

import business.gArmazem.Palete;
import java.util.Map;
import java.util.Queue;

public class GestorPaletes {
    private Queue<String> paleteQueue; //Paletes em espera para serem registadas
    private Map<String, Palete> paletes;//

    public GestorPaletes(Map<String, Palete> paletes, Queue<String> paleteQueue) {
        this.paletes = paletes;
        this.paleteQueue = paleteQueue;
    }

    public Map<String, Palete> getPaletes() { return paletes; }
    public void setPaletes(Map<String, Palete> paletes) { this.paletes = paletes; }

    public Queue<String> getPaleteQueue() { return paleteQueue; }
    public void setPaleteQueue(Queue<String> paleteQueue) { this.paleteQueue = paleteQueue; }


}
