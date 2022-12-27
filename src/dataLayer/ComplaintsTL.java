package dataLayer;

import uiLayer.Complaint;

public class ComplaintsTL {

    static ComplaintsTL complaintObj;
    private ComplaintsTL()
    {

    }
    public static ComplaintsTL getComplaintObj()
    {
        if(complaintObj==null)
        {
            complaintObj=new ComplaintsTL();
        }
        return complaintObj;
    }
    public void sendQuery(Complaint complaintObj)
    {
        String query="INSERT INTO Queries(Date,RollNo,Query) VALUES('"+complaintObj.getDate()+"','"+complaintObj.getRollNumber()+"','"+complaintObj.getQuery()+"')";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);
    }
    public java.sql.ResultSet getQueries()
    {
        String query="SELECT * FROM Queries";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }
    public boolean isQueryAvailable()
    {
        String query="SELECT EXISTS(SELECT * FROM Queries)AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
}
