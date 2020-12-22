package business.gLocalizacao;

import data.GestorDAO;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapa<L extends Localizacao> {
    private final Set<L> nodes;
    private final Map<Integer, Map<Integer, Double>> connections; // Map<ID do node origem, Map<ID do node destino, preço>>

    public Mapa(Set<L> nodes, Map<Integer, Map<Integer, Double>> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }


    public L getNode(int id) {
        return nodes.stream()
                .filter(node -> node.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No node found with ID"));
    }

    public Set<L> getConnections(L node) {
        return connections.get(node.getId()).keySet().stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }

}
