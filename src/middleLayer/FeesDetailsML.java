package middleLayer;

import dataLayer.FeesTL;

import uiLayer.FeesCl;

public class FeesDetailsML {
    FeesTL feesTLObj=FeesTL.getFeesTLObj();
    public java.sql.ResultSet getFeesDetail()
    {
        return feesTLObj.getFeesDetail();
    }
    public boolean isParticularAvailable()
    {
        return feesTLObj.isParticularAvailable();
    }
    public void setFees(FeesCl feesClObj)
    {
        feesTLObj.setFees(feesClObj);
    }
    public boolean isParticularAvailable(String particular)
    {
        return feesTLObj.isParticularAvailable(particular);

    }
    public void deleteParticular(String particular)
    {
        feesTLObj.deleteParticular(particular);
    }

    public java.sql.ResultSet getStudentsPaidDetails()
    {

        return feesTLObj.getStudentsPaidDetails();
    }

    //Student

    public boolean isColumnNameExists(String columnName,String rollNoOrName)
    {
        return feesTLObj.isColumnNameExists(columnName,rollNoOrName);

    }

    public java.sql.ResultSet getColumnNames()
    {

        return feesTLObj.getColumnNames();
    }

    public boolean getUnpaidColumnNames(String rollNoOrName,String columnName)
    {
        return feesTLObj.getUnpaidColumnNames(rollNoOrName,columnName);
    }

}
