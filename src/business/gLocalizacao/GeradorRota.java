package business.gLocalizacao;

import java.util.*;

public class GeradorRota<L extends Localizacao> {
    private final Mapa<L> mapa;
    private final Custos<L> nextNodeScore;
    private final Custos<L> targetScore;

    public GeradorRota(Mapa<L> mapa, Custos<L> nextNodeScorer, Custos<L> targetScorer) {
        this.mapa = mapa;
        this.nextNodeScore = nextNodeScorer;
        this.targetScore = targetScorer;
    }

    public List<L> findRoute(L from, L to) {
        Queue<business.gLocalizacao.Rota.Rota<L>> openSet = new PriorityQueue<>();
        Map<L, business.gLocalizacao.Rota.Rota<L>> allNodes = new HashMap<>();

        business.gLocalizacao.Rota.Rota<L> start = new business.gLocalizacao.Rota.Rota<>(from, null, 0d, targetScore.computeCost(from, to));
        openSet.add(start);
        allNodes.put(from, start);
        while (!openSet.isEmpty()) {
            business.gLocalizacao.Rota.Rota<L> next = openSet.poll();
            if (next.getCurrent().equals(to)) {
                List<L> route = new ArrayList<>();
                business.gLocalizacao.Rota.Rota<L> current = next;
                do {
                    route.add(0, current.getCurrent());
                    current = allNodes.get(current.getPrevious());
                } while (current != null);
                return route;
            }
            mapa.getConnections(next.getCurrent()).forEach(connection -> {
                business.gLocalizacao.Rota.Rota<L> nextNode = allNodes.getOrDefault(connection, new Rota.Rota<>(connection));
                allNodes.put(connection, nextNode);

                double newScore = next.getRouteScore() + nextNodeScore.computeCost(next.getCurrent(), connection);
                if (newScore < nextNode.getRouteScore()) {
                    nextNode.setPrevious(next.getCurrent());
                    nextNode.setRouteScore(newScore);
                    nextNode.setEstimatedScore(newScore + targetScore.computeCost(connection, to));
                    openSet.add(nextNode);
                }
            });
        }


        throw new IllegalStateException("No route found");
    }
}
