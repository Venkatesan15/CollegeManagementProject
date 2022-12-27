package middleLayer;
import dataLayer.ComplaintsTL;
import uiLayer.Complaint;

public class Complaints {
    ComplaintsTL complaintsTLObj=ComplaintsTL.getComplaintObj();
    public void sendQuery(Complaint complaintObj)
    {
        complaintsTLObj.sendQuery(complaintObj);
    }
    public java.sql.ResultSet getQueries()
    {
        return complaintsTLObj.getQueries();
    }
    public boolean isQueryAvailable()
    {
        return complaintsTLObj.isQueryAvailable();
    }
}
