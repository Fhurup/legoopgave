package FunctionLayer;

import Data.user;
import Data.DBConnector;
import Data.DataMapper;
import Data.Order;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static user login(String email, String password) throws LoginException {
        DataMapper dm = new DataMapper();
        return dm.getUser(email, password);

    }

    public static user createUser(String email, String name, String password) throws LoginException {
        user user = null;
        DataMapper dm = new DataMapper();
        boolean x = dm.makeUser(email, name, password);
        if (x) {
            user = dm.getUser(email, password);
            return user;
        } else {
            throw new LoginException("User already exists");
        }
    }

    public static boolean takeOrder(int length, int width, int height, String email) {
        DataMapper dm = new DataMapper();
        boolean x = dm.makeOrder(length, width, height, email);
        return x;
    }

    public static ArrayList<Order> getOrders(String email) {
        DataMapper dm = new DataMapper();
        ArrayList<Order> orderList = dm.getOrder(email);
        return orderList;
    }
    
    public static ArrayList<Order> getAllOrders(){
        DataMapper dm = new DataMapper();
        ArrayList<Order> orderList = dm.getAllOrder();
        return orderList;
    }

    public static void main(String[] args) throws LoginException {
        System.out.println(getAllOrders());
    }

}
