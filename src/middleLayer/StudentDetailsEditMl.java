package middleLayer;

import dataLayer.StudentsTL;
public class StudentDetailsEditMl {
    StudentsTL studentsTLObj=StudentsTL.getStudentsTLObj();
    public boolean isRollNoOrNameExists(String rollNoOrName)
    {
        return studentsTLObj.isRollNumberOrNameExists(rollNoOrName);
    }
    public java.sql.ResultSet getDetailsUsingRNOrName(String rollNoOrName)
    {
        return studentsTLObj.getDetailsUsingRNOrName(rollNoOrName);
    }
    public void editStudentDetail(String columnName, String changes, String rollNoOrName)
    {
        studentsTLObj.editStudentDetail(columnName, changes, rollNoOrName);
    }
    public void editAge(int age,String rollNoOrName)
    {
        studentsTLObj.editAge(age, rollNoOrName);
    }
    public void changeRegInStudentFeesTable(String rollNoOrName,String newRollNo)
    {
        studentsTLObj.changeRegInStudentFeesTable(rollNoOrName, newRollNo);

    }

    public void changeNameInStudentFeesTable(String rollNoOrName,String newName)
    {
        studentsTLObj.changeNameInStudentFeesTable(rollNoOrName, newName);

    }
}
