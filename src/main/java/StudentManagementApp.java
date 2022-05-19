import StudentManagementA.Student;
import StudentManagementA.StudentDao;

import java.sql.SQLException;

public class StudentManagementApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("----------");

        Student student = new Student();
        student.setSname("Syed");
        student.setScity("Bangalore");

        String addResult = StudentDao.insertStudent(student);
        System.out.println("Student 1 : " + addResult);

        Student student1 = new Student();
        student1.setSname("Ahmed");
        student1.setScity("Bagalkot");

        String addResult1 = StudentDao.insertStudent(student1);
        System.out.println("Student 2 : " + addResult1);

        String delResult = StudentDao.deleteStudentById(1);
        System.out.println(delResult);

        StudentDao.getAllStudents();

    }
}
