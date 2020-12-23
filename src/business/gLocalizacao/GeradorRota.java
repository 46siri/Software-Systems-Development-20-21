package business.gLocalizacao;

import java.util.*;

public class GeradorRota {
    private final Mapa mapa;

    public GeradorRota(Mapa mapa) {
        this.mapa = mapa;
    }

    // recebe um ponto inicial e um final e retorna a melhor rota
    public Rota findBestRout(Localizacao from, Localizacao to) {
        Queue<Rota> openSet = new PriorityQueue<>();//rotas a procurar ordenadas pela menor primeiro
        List<Localizacao> allNodes = new ArrayList<>();//Set com todas as Localizacoes usadas

        Rota start = new Rota(from);
        openSet.add(start);
        allNodes.add(from);
        while (!openSet.isEmpty()) {
            Rota next = openSet.poll();
            // Verifica se esta no nodo de destino e retorna o caminho desejado
            if (next.getCurrent().equals(to)) {
                return next;
            }
            //procurar
            for (Localizacao connection : mapa.getConnections(next.getCurrent())) {//forEach ligacao ao nodo em que estamos
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

    // transfroma a rota numa lista de locolizacoes
    public Stack<Localizacao> getTrajeto(Rota trajeto) {
        Stack<Localizacao> route = new Stack<>();
        Rota current = trajeto;
        do {
            route.add(0, current.getCurrent());
            current = current.getPrevious();
        } while (current != null);
        return route;
    }
}
