/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author frederik
 */
public class Order {
    private int height;
    private int width;
    private int length;
    private int orderID;
    private int x1;
    private int x2;
    private int x4;
    private String userName;

    public Order(int length, int width, int height, int x1, int x2, int x4, String userName, int orderID) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.x1 = x1;
        this.x2 = x2;
        this.x4 = x4;
        this.userName = userName;
        this.orderID = orderID; // fiks senere - generate
    }
    
    
    @Override
    public String toString() {
        return "Order{" + "height=" + height + ", width=" + width + ", length=" + length + ", orderID=" + orderID + ", x1=" + x1 + ", x2=" + x2 + ", x4=" + x4 + ", userName=" + userName + '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
