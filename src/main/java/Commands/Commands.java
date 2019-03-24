package Commands;

import FunctionLayer.LoginException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Commands {

    private static HashMap<String, Commands> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "placeOrder", new PlaceOrder() );
        commands.put( "getOrders", new GetOrders() );
  //      commands.put( "UnknownCommand", new UnknownCommand() );
             
    }

    static Commands from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginException, InvalidInputException;

}
