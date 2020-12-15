package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaleteDao {
    private Connection con;
    public void put (int id, String produto, int altura) throws SQLException {
        this.con = DriverManager.getConnection(
                "jdbc:sqlserver://Peter/dss","root","12345");
        PreparedStatement st = con.prepareStatement("INSERT INTO palete" + "VALUES(?,?,?);");

        st.setInt(1,id);
        st.setInt(3,altura);
        st.setString(2,produto);
        st.execute();
        con.close();

    }


}
