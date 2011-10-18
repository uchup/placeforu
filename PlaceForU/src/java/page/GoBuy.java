/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package page;

import dbase.DBconnection;
import dbase.DBorder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luwis
 */
public class GoBuy {
    public GoBuy(HttpServletRequest request){
        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        String telpon = request.getParameter("telpon");
        HttpSession session = request.getSession();
        List<Integer> cart = (List)session.getAttribute("cart");
        DBconnection dbConn = new DBconnection();
        DBorder dbOrder = new DBorder(dbConn.getConnection());
        try{
            for(int i=0; i<cart.size(); i++){
                dbOrder.insertOrder(nama, telpon, alamat, cart.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            dbConn.closeConnection();
        }
        session.removeAttribute("cart");
        session.invalidate();
    }
}
