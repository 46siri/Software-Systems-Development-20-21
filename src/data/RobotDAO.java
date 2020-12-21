package data;

import business.Robot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RobotDAO implements Map<String, Robot> {

    private static RobotDAO singleton = null;

    private RobotDAO(){
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS robots(" +
                    "Id varchar (10) NOT NULL PRIMARY KEY,"+
                    "Estado varchar(5) DEFAULT NULL)";
            stm.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }


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
    public Robot get(Object key) {
        return null;
    }

    @Override
    public Robot put(String key, Robot value) {
        return null;
    }

    @Override
    public Robot remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Robot> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Robot> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Robot>> entrySet() {
        return null;
    }
}
