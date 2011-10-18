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
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author luwis
 */
public class GoCart {
    HttpServletRequest request;

    public GoCart(HttpServletRequest request){
        this.request = request;
    }

    public String getPage(){
        String prodid = request.getParameter("prodid");
        HttpSession session = request.getSession();
        List<Integer> cart = (List)session.getAttribute("cart");

        if(prodid != null){
            int id = Integer.parseInt(prodid);
            if(cart == null){
                cart = new ArrayList<Integer>();
            }
            cart.add(id);
            session.setAttribute("cart", cart);
        }

        if(cart != null){
            DBconnection dbConn = new DBconnection();
            DBproduct dbProduct = new DBproduct(dbConn.getConnection());
            List<Product> order = new ArrayList<Product>();

            try{
                for(int i=0; i<cart.size(); i++){
                    Product product = new Product();
                    product = dbProduct.getProduct(cart.get(i));
                    order.add(product);
                }
                request.setAttribute("products", order);
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                dbConn.closeConnection();
            }
        }
        return "cart.jsp";
    }
}
