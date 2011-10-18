/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author luwis
 */
public class DBcategory {
    Connection conn;

    public DBcategory(Connection conn){
        this.conn = conn;
    }

    public Category getCategory(int id) throws Exception {
        String sql = "SELECT id,name FROM tblcategory WHERE id=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        Category category = null;
        st.setLong(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            category = new Category();
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
        }
        return category;
    }

    public List<Category> getAllCategory() throws Exception {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT id,name FROM tblcategory";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Category category = new Category();
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            categories.add(category);
        }
        return categories;
    }
}
