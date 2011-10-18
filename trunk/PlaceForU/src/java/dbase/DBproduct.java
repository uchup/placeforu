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
import model.Product;

/**
 *
 * @author luwis
 */
public class DBproduct {
    Connection conn;

    public DBproduct(Connection conn){
        this.conn = conn;
    }

    public Product getProduct(int id) throws Exception {
        Product product = null;
        String sql = "SELECT * FROM tblproduct WHERE id=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setSpec(rs.getString(3));
            product.setPrice(rs.getInt(4));
            product.setImage(rs.getString(5));
        }
        return product;
    }

    public List<Product> getProductByCategory(int category) throws Exception {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM tblproduct WHERE category=?";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.setInt(1, category);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setSpec(rs.getString(3));
            product.setPrice(rs.getInt(4));
            product.setImage(rs.getString(5));
            products.add(product);
        }
        return products;
    }

    public List<Product> getAllProduct() throws Exception {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM tblproduct";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setSpec(rs.getString(3));
            product.setPrice(rs.getInt(4));
            product.setImage(rs.getString(5));
            products.add(product);
        }
        return products;
    }
}
