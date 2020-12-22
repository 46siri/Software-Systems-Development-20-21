package data;

import business.RobotManager;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RobotDAO implements Map<String, RobotManager> {

    private static RobotDAO singleton = null;

    public static RobotDAO getInstance() {
        if (RobotDAO.singleton == null) {
            RobotDAO.singleton = new RobotDAO();
        }
        return RobotDAO.singleton;
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
    public RobotManager get(Object key) {
        return null;
    }

    @Override
    public RobotManager put(String key, RobotManager value) {
        return null;
    }

    @Override
    public RobotManager remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends RobotManager> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<RobotManager> values() {
        return null;
    }

    @Override
    public Set<Entry<String, RobotManager>> entrySet() {
        return null;
    }
}
