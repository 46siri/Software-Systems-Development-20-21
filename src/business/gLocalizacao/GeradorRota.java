package business.gLocalizacao;

import java.util.*;

public class GeradorRota {
    private Mapa mapa;

    /**
     * Constructor da Class
     */
    public GeradorRota(Mapa mapa) {
        this.mapa = mapa;
    }

    /**
     * Getters e Setters
     */
    public Mapa getMapa() {
        return mapa;
    }
    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    /**
     * Método que encontra o melhor percurso.
     *
     * @param from localizacao origem
     * @param to localizacao destino
     */
    public Rota findBestRout(int from, int to) {
        // Rotas a procurar ordenadas pela de menor custo.
        Queue<Rota> openSet = new PriorityQueue<>();
        // Set com todas as Localizacoes usadas.
        List<Integer> allNodes = new ArrayList<>();

        Rota start = new Rota(from);
        openSet.add(start);
        allNodes.add(from);
        while (!openSet.isEmpty()) {
            Rota next = openSet.poll();
            // Verifica se esta no nodo de destino e retorna o caminho desejado
            if (next.getCurrent() == to) {
                return next;
            }
            for (int connection : mapa.getConnections(next.getCurrent())) {//forEach ligacao ao nodo em que estamos
                if (!allNodes.contains(connection)) { //impede de procurar em nodos já usados
                    Rota nextNode = new Rota(connection, next, next.getValue());
                    nextNode.incrementValue(mapa.getDistance(next.getCurrent(), connection));

                    allNodes.add(connection);
                    openSet.add(nextNode);
                }
            }
        }
        throw new IllegalStateException("No route found");
    }

    /**
     * Método que transfroma a rota numa lista de locolizacoes.
     *
     * @param trajeto Rota a ser transformada em stack
     * @return Stack a ser enviada para o robot
     */
    public Stack<Integer> getTrajeto(Rota trajeto) {
        Stack<Integer> route = new Stack<>();
        Rota current = trajeto;
        do {
            route.add(0, current.getCurrent());
            current = current.getPrevious();
        } while (current != null);
        return route;
    }
}
