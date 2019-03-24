/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;


import Data.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frederik
 */
public class GetOrders extends Commands {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        String user = (String) request.getSession().getAttribute("email");
        List<Order> orders = LogicFacade.getOrders(user);
        request.getSession().setAttribute("order", orders);
        
        return "getOrders";
    }

    
}
