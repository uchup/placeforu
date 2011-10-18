/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author luwis
 */
public class DBconnection {
    Connection conn = null;

    public DBconnection() {
        String URL = "jdbc:mysql://localhost:3306/compshop";
        String USER = "root";
        String PASS = "qwerty";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception ex) {
            }
        }
    }
}
