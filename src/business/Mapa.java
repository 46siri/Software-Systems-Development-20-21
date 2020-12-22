package business;

import data.GestorDAO;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapa<L extends Localizacao> {
    private final Set<L> nodes;
    private final Map<Integer, Set<Integer>> connections; // Os ints são ids de localizacoes

    public Mapa(Set<L> nodes, Map<Integer, Set<Integer>> connections) {
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
        return connections.get(node.getId()).stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }

}
