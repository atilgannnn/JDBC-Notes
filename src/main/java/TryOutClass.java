import java.sql.Connection;
import java.sql.Statement;

public class TryOutClass {


    public static void main(String[] args) {


        // 1. Step : Connect to the Database
        Connection con = JdbcUtils.connectToDatabase("localhost","postgres","postgres","Flrnc555*");

        // 2. Step : Create Statement
        Statement st = JdbcUtils.createStatement();

        // 3. Step : Create a Table
        JdbcUtils.createTable("runners","students CHAR(20)","id INT");

        // 4. Step : Add Data
        String sql = "INSERT INTO runners VALUES ('yigit',26);"+
                     "INSERT INTO runners VALUES ('ibrahim',47);"+
                     "INSERT INTO runners VALUES ('fatma',100);"+
                     "INSERT INTO runners VALUES ('duhan',18);"+
                     "INSERT INTO runners VALUES ('yunus',42);"+
                     "INSERT INTO runners VALUES ('atilgan',6);";

        // 5. Step : ExecuteUpdate
        int execute = JdbcUtils.executeUpdate(sql);
        System.out.println("execute = " + execute);

        // 6. Step : Break the Connection
        JdbcUtils.closeConnectionAndStatement();


    }








}
