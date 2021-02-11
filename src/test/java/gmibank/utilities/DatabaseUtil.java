package gmibank.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatabaseUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    private static String databaseURL = ConfigurationReader.getProperty("database_url");
    private static String databaseUser = ConfigurationReader.getProperty("db_user");
    private static String databasePassword = ConfigurationReader.getProperty("db_password");



    public static void createConnection(){
        try{
            connection = DriverManager.getConnection(databaseURL,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createConnection(String url, String user, String password){
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
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

    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param query
     * @return returns query result in a list of lists where outer list represents
     *         collection of rows and inner lists represent a single row
     */
    public static List<List<Object>> getQueryResultList(String query){
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData metaData1;
        try {
              metaData1= resultSet.getMetaData();
            while(resultSet.next()){
                List<Object> row = new ArrayList<>();
                for (int i =0; i<=metaData1.getColumnCount();i++){
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }
    /**
     * @param query
     * @return returns query result in a list of maps where the list represents
     *         collection of rows and a map represents represent a single row with
     *         key being the column name
     */
    public static List<Map<String,Object>> getQueryResultMap(String query){
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
         ResultSetMetaData metaData;
        try {
            metaData = resultSet.getMetaData();
            while(resultSet.next()){
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i=0;i<=metaData.getColumnCount();i++){
                    colNameValueMap.put(metaData.getColumnName(i),resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("rowList = " + rowList);
        return rowList;
    }
    /**
     *
     * @param query
     * @return returns a single cell value. If the results in multiple rows and/or
     *         columns of data, only first column of the first row will be returned.
     *         The rest of the data will be ignored
     */
    public static Object getCellValue(String query,int row, int cell){
        return getQueryResultList(query).get(row).get(cell);
    }

    /**
     *
     * @param query
     * @return returns a list of Strings which represent a row of data. If the query
     *         results in multiple rows and/or columns of data, only first row will
     *         be returned. The rest of the data will be ignored
     */
    public static List<Object> getRowList(String query){
      return getQueryResultList(query).get(2);
    }

    /**
     *
     * @param query
     * @return returns a map which represent a row of data where key is the column
     *         name. If the query results in multiple rows and/or columns of data,
     *         only first row will be returned. The rest of the data will be ignored
     */
    public static Map<String,Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }

    /**
     * @param query
     * @param column
     * @return list of values of a single column from the result set
     */
    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();

        try {

            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("rowList = " + rowList);
        return rowList;
    }

    /**
     *
     * @param query
     * @return List of columns returned in result set
     */
    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
         ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }
    // ======== get column count with the query ======== //


    public static int getRowCount() throws Exception {
        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("rowCount = " + rowCount);
        return rowCount;
    }

    // ======== get column count with the query ======== //
    public static int getColumnCount() {

        ResultSetMetaData rsmd;
        int columnCount = 0;
        try {
            rsmd = resultSet.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("columnCount = " + columnCount);
        return columnCount;
    }

    /*
     * a method to display all the data in the result set
     *
     * */
    public static void displayAllData(String query) {
        executeQuery(query);
        // get the first row data  | without knowing the column names
        int colCount = DatabaseUtil.getColumnCount();
        // in order to get whole result cursor must be at before first location !
        try {
            // in order to start from beginning , we should be at beforefirst location
            resultSet.beforeFirst(); // this is for below loop to work
            while (resultSet.next() == true) { // row iteration
                for (int i = 1; i <= colCount; i++) { // column iteration
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println(); // adding a blank line for next line
            }
            // now the cursor is at after last location
            // move it back to before first location so we can have no issue calling the method again
            // rs.beforeFirst(); // this is for next method that might need to be at before first location
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ALL DATA");
            e.printStackTrace();
        }
    }
}
