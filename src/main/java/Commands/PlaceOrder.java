/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;


import FunctionLayer.LogicFacade;
import FunctionLayer.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author frederik
 */
public class PlaceOrder extends Commands {

    public PlaceOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws InvalidInputException {
        try{
        String cus = (String) request.getSession().getAttribute("email");
        int length = Integer.parseInt(request.getParameter("l"));
        int width = Integer.parseInt(request.getParameter("w"));
        int height = Integer.parseInt(request.getParameter("h"));
        LogicFacade.takeOrder(length,width,height, cus);
        return "Shop";
        }catch(Exception ex){
            throw new InvalidInputException("Invalid input");
        }
    }
}
