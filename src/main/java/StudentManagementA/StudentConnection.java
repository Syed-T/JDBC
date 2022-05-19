package StudentManagementA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
    static Connection connection;
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        try {
            String name = "root";
            String pass = "root";
            String url = "jdbc:mysql://localhost:3306/student_manage";

            connection = DriverManager.getConnection(url, name, pass);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
