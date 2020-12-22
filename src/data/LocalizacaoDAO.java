package data;


import java.sql.*;

public class LocalizacaoDAO{

    private LocalizacaoDAO(){
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS localizacoes(" +
                    "Zona varchar (10) NOT NULL PRIMARY KEY,"+
                    "Seccao varchar(10) DEFAULT NULL," +
                    "Prateleira varchar(10))";
            stm.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}
