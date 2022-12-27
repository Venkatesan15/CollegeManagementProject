package middleLayer;

import dataLayer.AttendanceTL;

import uiLayer.AttendanceCl;

public class AttendanceML {
    AttendanceTL attendanceTLObj=AttendanceTL.getAttendanceTLObj();
    public void attendanceML(AttendanceCl attendanceClObj)
    {
        attendanceTLObj.insertAttendance(attendanceClObj);
    }

    public boolean isAttendanceHistoryAvailable(String date)
    {
        return attendanceTLObj.isAttendanceHistoryAvailable(date);
    }

    public java.sql.ResultSet getAttendanceHistory(String date)
    {
        return attendanceTLObj.getAttendanceHistory(date);
    }

    public boolean isRollNoAvailOnAttendance(String rollNo)
    {
        return attendanceTLObj.isRollNoAvailOnAttendance(rollNo);
    }

    public java.sql.ResultSet getAttendanceHistoryByRollNo(String rollNo)
    {
        return attendanceTLObj.getAttendanceHistoryByRollNo(rollNo);
    }


}