package gmibank.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;



    public static void createConnection(String url,String user, String password){
        try{
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try{
            if (resultSet!=null) {
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }

        }   catch (Exception e){
            e.printStackTrace();

        }
    }

//    public static Map<String,Object> getQueryResultMap(String query){
//    }


}
