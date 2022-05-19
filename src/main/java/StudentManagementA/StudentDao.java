package StudentManagementA;

import java.sql.*;

public class StudentDao {
    public static String insertStudent(Student student) throws SQLException, ClassNotFoundException{
        //JDBC code

        try {
            Connection connection = StudentConnection.createConnection();
            //make a query
            String query = "insert into students(sname, scity) values(?, ?)";
            //for dynamic query use PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student.getSname());
            preparedStatement.setString(2, student.getScity());

            //execute
            preparedStatement.executeUpdate();
            return "Successfully added";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String deleteStudentById(int sid) throws ClassNotFoundException {
        try {
            Connection connection = StudentConnection.createConnection();
            //make a query
            String query = "delete from students where sid = ?";
            //for dynamic query use PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, sid);

            //execute
            preparedStatement.executeUpdate();
            return "Successfully deleted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAllStudents() throws ClassNotFoundException{
        try {
            Connection connection = StudentConnection.createConnection();
            //make a query
            String query = "select * from students";
            // static query : use Statement
            Statement statement = connection.createStatement();
            //execute
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int sid = resultSet.getInt("sid");
                String sname = resultSet.getString("sname");
                String scity = resultSet.getString("scity");

                System.out.println("sid : " + sid + " sname : " + sname + " scity : " + scity);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
