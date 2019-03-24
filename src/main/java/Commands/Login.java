package Commands;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Data.user;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Commands {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("email", user.getEmail());
        return "Shop";
        
    }

}
