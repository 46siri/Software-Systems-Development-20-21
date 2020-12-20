package data;

import business.Gestor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GestorDAO implements Map<String, Gestor> {
    private static GestorDAO singleton = null;

    public static GestorDAO getInstance() {
        if (GestorDAO.singleton == null) {
            GestorDAO.singleton = new GestorDAO();
        }
        return GestorDAO.singleton;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Gestor get(Object key) {
        return null;
    }

    @Override
    public Gestor put(String key, Gestor value) {
        return null;
    }

    @Override
    public Gestor remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Gestor> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Gestor> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Gestor>> entrySet() {
        return null;
    }
}
