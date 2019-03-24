package Commands;

import Data.user;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Commands {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        
        if (password1.equals(password2)) {
            user user = LogicFacade.createUser(email, "john doe", password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("email", user.getEmail());
            return "Shop";
        } else {
            throw new LoginException("the two passwords did not match");
        }
    }

}
