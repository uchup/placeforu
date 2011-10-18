/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbase;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author luwis
 */
public class DBorder {
    Connection conn;

    public DBorder(Connection conn){
        this.conn = conn;
    }

    public void insertOrder(String name, String phone, String address, int id) throws Exception {
        String sql = "INSERT INTO tblorder (name, phone, address, prod_id) VALUES(?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, phone);
        st.setString(3, address);
        st.setInt(4, id);
        st.executeUpdate();
        st.close();
    }
}
