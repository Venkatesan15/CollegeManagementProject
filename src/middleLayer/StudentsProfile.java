package middleLayer;
import dataLayer.StudentsTL;
import uiLayer.Student;

public class StudentsProfile {
    StudentsTL studentsTLObj=StudentsTL.getStudentsTLObj();
    public  void addStudent(Student studentInfo)
    {
        studentsTLObj.addStudent(studentInfo);
    }
    public boolean isRollNumberOrNameExists(String rollNoOrName)
    {
        return studentsTLObj.isRollNumberOrNameExists(rollNoOrName);
    }
    public java.sql.ResultSet getStudentProfile(String rollNoOrName)
    {
        return studentsTLObj.getStudentProfile(rollNoOrName);
    }

    public java.sql.ResultSet getStudentsList()
    {
        return studentsTLObj.getStudentsList();
    }
    public java.sql.ResultSet getName()
    {
        return studentsTLObj.getName();
    }
}
