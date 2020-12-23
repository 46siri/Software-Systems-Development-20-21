package business.gLocalizacao;

import data.GestorDAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapa {
    private Set<Integer> nodes;
    private Map<Integer, Map<Integer, Double>> connections; // Map<ID do node origem, Map<ID do node destino, preço>>

    public Mapa(Set<Integer> nodes, Map<Integer, Map<Integer, Double>> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    public Mapa() {
        this.nodes = new HashSet<>();
        int i = 17;
        while ( i > 0) {
            this.nodes.add(--i);
        }
        this.connections = new HashMap<>();
        //nodo 0
        this.connections.put(0, new HashMap<>());
        this.connections.get(0).put(1,3d);
        //nodo 1
        this.connections.put(1, new HashMap<>());
        this.connections.get(1).put(0,3d);
        this.connections.get(1).put(7,3d);
        this.connections.get(1).put(2,7d);
        //nodo 2
        this.connections.put(2, new HashMap<>());
        this.connections.get(2).put(1,7d);
        this.connections.get(2).put(12,3d);
        //nodo 3
        this.connections.put(3, new HashMap<>());
        this.connections.get(3).put(12,3d);
        this.connections.get(3).put(5,3.5);
        //nodo 4
        this.connections.put(4, new HashMap<>());
        this.connections.get(4).put(5,3.5);
        this.connections.get(4).put(16,3d);
        //nodo 5
        this.connections.put(5, new HashMap<>());
        this.connections.get(5).put(3,3.5);
        this.connections.get(5).put(4,3.5);
        this.connections.get(5).put(6,3d);
        //nodo 6
        this.connections.put(6, new HashMap<>());
        this.connections.get(6).put(5,3d);
        //nodo 7
        this.connections.put(7, new HashMap<>());
        this.connections.get(7).put(1,3d);
        this.connections.get(7).put(8,3d);
        //nodo 8
        this.connections.put(8, new HashMap<>());
        this.connections.get(8).put(7,3d);
        this.connections.get(8).put(9,3d);
        //nodo 9
        this.connections.put(9, new HashMap<>());
        this.connections.get(9).put(8,3d);
        this.connections.get(9).put(10,3d);
        //nodo 11
        this.connections.put(11, new HashMap<>());
        this.connections.get(11).put(10,3d);
        this.connections.get(11).put(3,3d);
        //nodo 12
        this.connections.put(12, new HashMap<>());
        this.connections.get(12).put(2,3d);
        this.connections.get(12).put(13,3d);
        //nodo 13
        this.connections.put(13, new HashMap<>());
        this.connections.get(13).put(12,3d);
        this.connections.get(13).put(14,3d);
        //nodo 14
        this.connections.put(14, new HashMap<>());
        this.connections.get(14).put(13,3d);
        this.connections.get(14).put(15,3d);
        //nodo 15
        this.connections.put(15, new HashMap<>());
        this.connections.get(15).put(14,3d);
        this.connections.get(15).put(16,3d);
        //nodo 16
        this.connections.put(16, new HashMap<>());
        this.connections.get(16).put(11,3d);
        this.connections.get(16).put(4,3d);
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
