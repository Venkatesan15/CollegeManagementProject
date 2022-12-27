package middleLayer;

import dataLayer.TimeTableTL;

import uiLayer.TimeTableCl;

public class TimeTableML {
    TimeTableTL timeTableTLObj=TimeTableTL.getTimeTableTLObj();
    public boolean isDayOrderAvailable(int dO)
    {

        return timeTableTLObj.isDayOrderAvailable(dO);
    }
    public void editUsingDayOrder(TimeTableCl ttObj)
    {
        timeTableTLObj.editUsingDayOrder(ttObj);
    }
    public void insertIntoTimeTable(TimeTableCl timeTableClObj)
    {
        timeTableTLObj.insertIntoTimeTable(timeTableClObj);
    }
    public void deleteTimeTable()
    {
        timeTableTLObj.deleteTimeTable();
    }
    public java.sql.ResultSet getTimeTable()
    {
        return timeTableTLObj.getTimeTable();
    }
}
