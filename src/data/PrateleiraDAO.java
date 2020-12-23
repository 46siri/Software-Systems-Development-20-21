package data;

import business.gArmazem.Prateleira;

import java.sql.*;

public class PrateleiraDAO{

    private PrateleiraDAO(){
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS prateleiras(" +
                    "Num varchar(45) DEFAULT NULL," +
                    "Localizacao " +
                    "Estado )";
            stm.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}
