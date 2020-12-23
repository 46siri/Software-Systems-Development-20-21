package data;

import business.gConta.Gestor;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Versão incompleta de um DAO para Gestor
 *
 * Tabelas a criar na BD: ver método getInstance
 *
 * @author Grupo0
 * @version 202012
 */
public class GestorDAO implements Map<String, Gestor> {
    private static GestorDAO singleton = null;

    private GestorDAO(){
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement()) {
            String sql= "CREATE TABLE IF NOT EXISTS gestores (" +
                    "Username varchar (45) NOT NULL PRIMARY KEY," + 
                    "Password varchar(45) DEFAULT NULL," +
                    "Nome varchar(45) DEFAULT NULL," +
                    "Email varchar(45) DEFAULT NULL)";
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
    public static GestorDAO getInstance(){
        if (GestorDAO.singleton == null) {
            GestorDAO.singleton = new GestorDAO();
        }
        return GestorDAO.singleton;
    }

    /**
     * @return número de gestores na base de dados
     */
    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM gestores")) {
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
    }

    /**
     * Método que verifica se existem gestores
     *
     * @return true se existirem 0 gestores
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Método que cerifica se um Username de gestor existe na base de dados
     *
     * @param key Username do Gestor
     * @return true se o Gestor existe
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public boolean containsKey(Object key) {
        boolean r;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs =
                     stm.executeQuery("SELECT Username FROM gestores WHERE Username='"+key.toString()+"'")) {
            r = rs.next();
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    /**
     * Verifica se uma Gestor existe na base de dados
     *
     * @param value Username da Gestor
     * @return true se Gestor existe
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public boolean containsValue(Object value) {
        Gestor g = (Gestor) value;
        return this.containsKey(g.getUserName());
    }

    /**
     * Obter uma Gestor, dado o seu Username
     *
     * @param key Username da Gestor
     * @return o Gestor caso exista (null noutro caso)
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public Gestor get(Object key) {
        Gestor g = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM gestores WHERE Username='"+key+"'")) {
            if (rs.next()) {  // A chave existe na tabela
                g = new Gestor(rs.getString("Username"), rs.getString("Password"), rs.getString("Nome"),rs.getString("Email"));
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return g;
    }

    /**
     * Insere uma Gestor na base de dados
     *
     * ATEN&Ccedil;&Acirc;O: Falta devolver o valor existente (caso exista um)
     *
     * @param key o Username da Gestor
     * @param g a Gestor
     * @return devolve o valor existente, caso exista um
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exep&ccedil;&otilde;es do projecto
     */
    @Override
    public Gestor put(String key, Gestor g) {
        Gestor res = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
             stm.executeUpdate(
                    "INSERT INTO gestores VALUES('"+g.getUserName()+"', '"+g.getPassword()+"', '"+g.getNome()+"','"+g.getEmail()+"') " +
                            "ON DUPLICATE KEY UPDATE Password=VALUES(Password), Nome=VALUES(Nome), Email=VALUES(Email)");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    /**
     * Remover uma Gestor, dado o seu Username
     *
     * @param key Username da Gestor a remover
     * @return a Gestor removida
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public Gestor remove(Object key) {
        Gestor p = this.get(key);
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM gestores WHERE Num='"+key+"'");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    /**
     * Adicionar um conjunto de gestores à base de dados
     *
     * @param gestores a adicionar
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public void putAll(Map<? extends String, ? extends Gestor> gestores) {
        for(Gestor g : gestores.values()) {
            this.put(g.getUserName(), g);
        }
    }

    /**
     * Apagar todas as gestores
     *
     * @throws NullPointerException Em caso de erro - deveriam ser criadas exepções do projecto
     */
    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("TRUNCATE gestores");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    /**
     * @return Todos as gestores da base de dados
     */
    @Override
    public Collection<Gestor> values() {
        Collection<Gestor> col = new HashSet<>();
        try(Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Username FROM gestores")) {
            while (rs.next()) {   // Utilizamos o get para construir as gestores
                col.add(this.get(rs.getString("Username")));
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return col;
    }

    @Override
    public Set<Entry<String, Gestor>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Gestor>> entrySet() not implemented!");
    }
}
