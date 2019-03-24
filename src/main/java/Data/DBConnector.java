
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class DBConnector {
    private Connection connection = null;
	
	//Constants
	private static final String IP	     = "167.99.222.192";
	private static final String PORT     = "3306";
	public  static final String DATABASE = "mydb";
	private static final String USERNAME = "reader"; 
	private static final String PASSWORD = "something123";	     	
	
	public DBConnector() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                Properties props = new Properties();
                props.put("user", USERNAME);
                props.put("password", PASSWORD);
                props.put("allowMultiQueries", true);
                props.put("useUnicode", true);
                props.put("useJDBCCompliantTimezoneShift", true);
                props.put("useLegacyDatetimeCode", false);
                props.put("serverTimezone", "CET");
                this.connection = DriverManager.getConnection(url, props);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
                throw new SQLException(ex.getMessage());
            }
	}
	
	public Connection getConnection() {
   		return this.connection;
	}
        
//        public static void main(String[] args) throws SQLException {
//            DBConnector db = new DBConnector();
//            ArrayList<user> Users = new ArrayList();
//            String query = "SELECT * FROM `user`;";
//            Connection connection = db.getConnection();
//            ResultSet rs = connection.createStatement().executeQuery(query);
//            while (rs.next()) {
//                user user = new user(rs.getString("email"), rs.getString("name"), rs.getString("password"));
//                Users.add(user);
//            }
//            System.out.println(Users);
//        
//    }
}


