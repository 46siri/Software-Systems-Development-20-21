package business.gLocalizacao;

import data.GestorDAO;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapa {
    private final Set<Integer> nodes;
    private final Map<Integer, Map<Integer, Double>> connections; // Map<ID do node origem, Map<ID do node destino, preço>>

    public Mapa(Set<Integer> nodes, Map<Integer, Map<Integer, Double>> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    public int getNode(int id) {
        return nodes.stream()
                .filter(node -> node == (id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No node found with ID"));
    }

    public Set<Integer> getConnections(int node) {
        return connections.get(node).keySet().stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }

    public double getDistance(int from, int to) {
        return connections.get(from).get(to);
    }

}
