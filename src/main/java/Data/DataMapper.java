/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import FunctionLayer.LoginException;
import FunctionLayer.buildCalculator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author frederik
 */
public class DataMapper {

    public user getUser(String email, String password) throws LoginException {
        try {
            String query = "select * from `user` where email='" + email + "';";
            Connection connection = new DBConnector().getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            rs.next();
            if (rs.getString("password").equals(password)) {
                return new user(rs.getString("email"), rs.getString("name"), rs.getString("password"));
            } else {
                throw new LoginException("Wrong password");
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean makeUser(String email, String name, String password) {
        try {
            String query = "insert into `user` values ('" + email + "', '" + name + "', '" + password + "');";
            Connection connection = new DBConnector().getConnection();
            connection.createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean makeOrder(int length, int width, int height, String email) {
        int generatedID = getAllOrder().size() + 100;
        try {
            String query = "insert into `order` values (" + generatedID + "," + length + "," + width + "," + height + ",'" + email + "');";
            Connection connection = new DBConnector().getConnection();
            connection.createStatement().executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ArrayList<Order> getOrder(String email) {
        ArrayList<Order> orderList = new ArrayList();
        try {
            String query = "select * from `order` where user_email='" + email + "';";
            Connection connection = new DBConnector().getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);

            while (rs.next()) {

                buildCalculator bc = new buildCalculator();
                int[] k = bc.builder(rs.getInt("length"), rs.getInt("width"), rs.getInt("height"));
                Order o = new Order(rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), k[2], k[1], k[0], rs.getString("user_email"), rs.getInt("idorder"));
                orderList.add(o);
            }
        } catch (SQLException ex) {
            return null;
        }
        return orderList;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> allOrders = new ArrayList();
        try {
            String query = "SELECT * FROM mydb.`order`;";
            Connection connection = new DBConnector().getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {

                buildCalculator bc = new buildCalculator();
                int[] k = bc.builder(rs.getInt("length"), rs.getInt("width"), rs.getInt("height"));
                Order o = new Order(rs.getInt("length"), rs.getInt("width"), rs.getInt("height"), k[0], k[1], k[2], rs.getString("user_email"), rs.getInt("idorder"));
                allOrders.add(o);
            }
        } catch (SQLException ex) {
            return null;
        }
        return allOrders;

    }

    public static void main(String[] args) throws SQLException, LoginException {

        DataMapper dm = new DataMapper();
//        System.out.println(dm.makeOrder(0, 0, 0, "dig"));
//          System.out.println(dm.getUser("dig", "med"));
//        Order o = dm.getOrder("noget");
//        System.out.println(o);
//        boolean om = dm.makeUser("hej", "med", "dig");
//        System.out.println(om);
//        Order o = new Order(5,5,5,5,5,5,"noget");
//        System.out.println(o);
//        boolean k = dm.makeOrder(o);
//        System.out.println(k);
    }
}
