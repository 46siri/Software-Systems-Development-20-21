package business;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Rota{
    private final Set<Localizacao> nodes;
    private final Map<Integer, Set<Integer>> connections; // Os ints são ids de localizacoes

    public Rota(Set<Localizacao> nodes, Map<Integer, Set<Integer>> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    public Localizacao getNode(int id) {
        return nodes.stream()
                .filter(node -> node.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No node found with ID"));
    }

    public Set<Localizacao> getConnections(Localizacao node) {
        return connections.get(node.getId()).stream()
                .map(this::getNode)
                .collect(Collectors.toSet());
    }

}
