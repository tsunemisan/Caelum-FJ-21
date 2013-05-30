package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","tsunen123");
    }
}

