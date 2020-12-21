package data;

import business.Palete;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalizacaoDAO {
    private static LocalizacaoDAO singleton = null;

    private LocalizacaoDAO(){
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS localizacoes(" +
                    "Zona varchar (10) NOT NULL PRIMARY KEY,"+
                    "Seccao varchar() DEFAULT NULL," +
                    "Prateleira varchar(10))";
            stm.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * Implementação do padrão Singleton
     *
     * @return devolve a instância única desta classe
     */
    public static LocalizacaoDAO getInstance(){
        if (LocalizacaoDAO.singleton == null) {
            LocalizacaoDAO.singleton = new LocalizacaoDAO();
        }
        return LocalizacaoDAO.singleton;
    }
}
