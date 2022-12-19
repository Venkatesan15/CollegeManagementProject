package uiLayer.adminDashboard;

import middleLayer.StudentDetailsEditMl;
import creationValidator.OnlyInt;
import creationValidator.StudentInfo;
import uiLayer.Student;

import java.sql.ResultSet;
import java.util.Scanner;

public class StudentDetailChange {
    public void usingName()
    {
        System.out.println("Please Enter Student Name");
        Scanner sc=new Scanner(System.in);
        String rollNumberOrName =sc.nextLine();
        int res= editUsingRollNoOrName(rollNumberOrName);
        if(res==0)
        {
            System.out.println("The Name Is Wrong");
            if(choose()) {
                usingName();
            }
            else {
                return;
            }
        }
    }
    public void usingRollNumber()
    {
        System.out.println("Please Enter Student Roll Number");
        Scanner sc=new Scanner(System.in);
        String rollNumberOrName =sc.nextLine();
        int res= editUsingRollNoOrName(rollNumberOrName);
        if(res==0)
        {
            System.out.println("The Roll Number Is Wrong");

            if(choose()) {
                usingRollNumber();
            }
            else {
                return;
            }
        }
    }
    public void showDetails(ResultSet rs)
    {
        try {
            rs.next();


            String name=rs.getString("Name");
            String rollNo=rs.getString("RollNumber");
            String gender=rs.getString("Gender");
            String phNo=rs.getString("PhoneNumber");
            String dob=rs.getString("DOB");
            int age=rs.getInt("Age");

            Student studentObj=new Student(rollNo,name,gender,phNo,dob,age);

            System.out.println("Name         : " + studentObj.getName());
            System.out.println("Roll Number  : " + studentObj.getRollNo());
            System.out.println("Gender       : " + studentObj.getGender());
            System.out.println("Phone Number : " + studentObj.getPhNo());
            System.out.println("DOB          : " + studentObj.getDob());
            System.out.println("*************************");

        }
        catch (Exception e)
        {
            System.out.println("Exception in StudentDetailChange  :  "+e);

        }
    }
    public void edit(String rollNoOrName)
    {
        System.out.println("Please Enter Which One You Want(Name||RollNumber||Gender||PhoneNumber||DOB)");
        Scanner sc=new Scanner(System.in);
        String process=sc.nextLine();
        StudentDetailsEditMl studentDetailsEditMlObj =new StudentDetailsEditMl();
        StudentInfo studentInfoObj =new StudentInfo();
        switch (process)
        {
            case "Name":
                String name= studentInfoObj.enterName();
                studentDetailsEditMlObj.editStudentDetail("Name",name, rollNoOrName);
                studentDetailsEditMlObj.changeNameInStudentFeesTable(rollNoOrName,name);

                System.out.println("Changed Successfully");

                break;
            case "Gender":
                String gender= studentInfoObj.enterGender();
                studentDetailsEditMlObj.editStudentDetail("Gender",gender, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "PhoneNumber":
                String phNo= studentInfoObj.enterPhoneNumber();
                studentDetailsEditMlObj.editStudentDetail("PhoneNumber",phNo, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "DOB":
                String dob= studentInfoObj.studentDOB();
                studentDetailsEditMlObj.editStudentDetail("DOB",dob, rollNoOrName);

                int age= studentInfoObj.getAge(dob);
                studentDetailsEditMlObj.editAge(age, rollNoOrName);
                System.out.println("Changed Successfully");
                break;
            case "RollNumber":
                String newRollNumber= studentInfoObj.enterRollNumber();
                studentDetailsEditMlObj.editStudentDetail("RollNumber",newRollNumber, rollNoOrName);

                studentDetailsEditMlObj.changeRegInStudentFeesTable(rollNoOrName,newRollNumber);
                System.out.println("Changed Successfully");
                break;
            default:
                System.out.println("Please Enter Valid Process");
                edit(rollNoOrName);
        }
    }
    public int editUsingRollNoOrName(String rollNumberOrName)
    {
        StudentDetailsEditMl studentDetailsEditMlObj =new StudentDetailsEditMl();
        if(studentDetailsEditMlObj.isRollNoOrNameExists(rollNumberOrName))
        {
            try {
                ResultSet rs = studentDetailsEditMlObj.getDetailsUsingRNOrName(rollNumberOrName);
                showDetails(rs);
                int userInput=1;
                while (userInput == 1) {
                    System.out.println("Edit----->1");
                    System.out.println("Back----->2");
                    userInput = OnlyInt.onlyInt();
                    if (userInput == 1) {
                        edit(rollNumberOrName);
                    } else if (userInput == 2) {
                        return 1;
                    } else {
                        System.out.println("Please Enter Valid Input");
                        userInput = 1;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Something Went Wrong");
            }
            return  1;
        }
        else
        {
            return 0;
        }
    }
    public boolean choose()
    {
        System.out.println("Try Again-------------->1");
        System.out.println("Leave From this Page--->2");
        int ui= OnlyInt.onlyInt();
        if(ui==1)
        {
            return true;
        }
        else if(ui!=2)
        {
            System.out.println("Please Enter Valid Input");
            choose();
        }
        return false;
    }

}

