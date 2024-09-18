package Employeedbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DbConnection {
    public static Connection getConnectToEmpAttd() throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=null;
       String url="jdbc:mysql://localhost:3306/";
       String dbName="empdetials";
       String userName="root";
       String password="amazon";
       con=DriverManager.getConnection(url+dbName,userName, password);
       return con; 
}

    static Employeedbms.Connection getConnectToStudAttd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}