import java.sql.*;

public class JdbcUtils {

    public static void main(String[] args) {

        createTable("abc","name VARCHAR(17)","id INT","address VARCHAR(80)");

    }



    private static Connection connection;
    private static Statement statement;

    private static ResultSet rst1;

    //1. Adım: Driver'a kaydol
    //2. Adım: Datbase'e bağlan

    public static Connection connectToDatabase(String hostName, String dbName, String username, String password){


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
             connection = DriverManager.getConnection("jdbc:postgresql://"+hostName+":5432/"+dbName,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (connection!=null){

            System.out.println("Connection Success");

        }else{

            System.out.println("Connection Fail");
        }

        return connection;
    }

    public static Statement createStatement(){


        //3. Adım: Statement oluştur.
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return statement;
    }

    //4. Adım : Query çalıştır.
    public static boolean execute(String sql){

    boolean isExecute;
    try {
        isExecute = statement.execute(sql);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


    return isExecute;
}


    public static ResultSet executeQuery(String sql){

        try {
            rst1 = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return rst1;
    }

    public static int executeUpdate(String sql){
        int updateLine;
        try {
            updateLine = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return updateLine;
    }


    //5. Adım: Bağlantı ve Statement'ı kapat.
    public static void closeConnectionAndStatement(){

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed()&& statement.isClosed()){

                System.out.println("Connection and Statement Closed!");

            }else{

                System.out.println("Connection and Statement NOT Closed!");


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //Table oluşturan method

    public static void createTable(String tableName, String... columnName_dataType){

        StringBuilder columnName_dataValue = new StringBuilder("");

        for (String w : columnName_dataType){

            columnName_dataValue.append(w).append(",");

        }

        columnName_dataValue.deleteCharAt(columnName_dataValue.length()-1);
        System.out.println(columnName_dataValue);


        try {
            statement.execute(    "CREATE TABLE "+tableName+"("+columnName_dataValue+")");
            System.out.println("Table "+tableName+" successfully created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }





}
