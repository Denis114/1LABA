package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Денис
 */
public class Dao {

    DataSource ds;
    Connection connection;


    public Dao() {

    }

    public void initConnection() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/myBasa");
        } catch (NamingException ex) {

        }
    }

    public void openConnection() {
        initConnection();
        try {
            connection = ds.getConnection();
            //connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException ex) {

        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {

        }
    }

}
