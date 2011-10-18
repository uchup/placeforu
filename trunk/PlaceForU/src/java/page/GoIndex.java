/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package page;

import dbase.DBconnection;
import dbase.DBproduct;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Product;

/**
 *
 * @author luwis
 */
public class GoIndex {
    HttpServletRequest request;

    public GoIndex(HttpServletRequest request){
        this.request = request;
    }

    public String getPage(){
        String catid = request.getParameter("catid");
        DBconnection dbConn = new DBconnection();
        List<Product> product = new ArrayList<Product>();
        DBproduct dbProduct = new DBproduct(dbConn.getConnection());
        if (catid == null){
            catid = "0";
        }

        int category = Integer.parseInt(catid);
        try{
            if(category == 0){
               product = dbProduct.getAllProduct();
            } else {
               product = dbProduct.getProductByCategory(category);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            dbConn.closeConnection();
        }
        request.setAttribute("products", product);
        return "index.jsp";
    }
}
