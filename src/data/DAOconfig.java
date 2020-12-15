package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOconfig {


    public static void main(String[]args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://Peter/coise","root","12345");
        //PaleteDao p = new PaleteDao();
        //p.put(1,"siri",150, con);
        con.close();
        System.out.println("ola");
    }
}
