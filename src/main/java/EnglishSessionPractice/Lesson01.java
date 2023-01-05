package EnglishSessionPractice;

import java.sql.*;

public class Lesson01 {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Sign up to the driver
        Class.forName("org.postgresql.Driver");

        //Connect to database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Flrnc555*");

        //Create statement
        Statement st = con.createStatement();

        //Testing the connection
        System.out.println("It's working");

        String sql1 = "CREATE TABLE workers (id CHAR(20), name VARCHAR(15), salary REAL);";
        boolean a = st.execute(sql1);

        System.out.println(a);

        String sql2 = "INSERT INTO workers VALUES (12345,'AHMET',10000);"+
                      "INSERT INTO workers VALUES (23456,'DUHAN',20000);"+
                      "INSERT INTO workers VALUES (34567,'FATMA',25000);";

        boolean b = st.execute(sql2);

        System.out.println(b);

        String sql3 = "SELECT salary,name FROM workers WHERE salary<25000;";

        ResultSet rs1 = st.executeQuery(sql3);

        while (rs1.next()){


            System.out.println(rs1.getDouble("salary")+" "+" "+rs1.getString("name"));


        }










    }







}
