package unilms;

import java.sql.*;

public class DBLoader 
{
   public static ResultSet executeSQL(String sql)
   {
       try
       {
            /////////////////    ## Code    //////////////
           
           // =========================================== code ===========
            //Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver loading done");
            
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/unilms", "root", "system");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/unilms", "root", "system");
           
           
           
            
            // Azure Logins Hidden

            System.out.println("Connection done");
            
            
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            



            Statement stmt = myDbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            
            
            
            
            
            System.out.println("Statement done");
            
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ResultSet Created");  
            
            System.out.println(sql);
            
            return rs;
           
           /////////////// ## Code Ends Here /////////////
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           
           return null;
       }
           
   }
}
