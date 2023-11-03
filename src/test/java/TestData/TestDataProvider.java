package TestData;

import utilities.ReadPropertyFile;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class TestDataProvider {
    ReadPropertyFile fr = new ReadPropertyFile();

    public  Object [][] loginTestData() throws IOException {
        Object [] [] data = new Object [2] [2];
        data[0][0]= fr.getPropertyValue("username1");
        data[0][1]=fr.getPropertyValue("password1");
        data[1][0]= fr.getPropertyValue("username2");
        data[1][1]=fr.getPropertyValue("password2");
        return data;
    }


    public  Object [][] addDashboardTestData() throws IOException {
        Object [] [] data = new Object [2] [2];
        data[0][0]= fr.getPropertyValue("DashboardName1");
        data[0][1]=fr.getPropertyValue("DashboardDes1");
        data[1][0]= fr.getPropertyValue("DashboardName2");
        data[1][1]=fr.getPropertyValue("DashboardDes2");
        return data;
    }


    public Object[][] addWidgetTestData() throws IOException {
        Object [] [] data = new Object [2] [3];
        data[0][0]= fr.getPropertyValue("widgetName1");
        data[0][1]=fr.getPropertyValue("widgetDes1");
        data[0][2]=fr.getPropertyValue("Filter1");
        data[1][0]= fr.getPropertyValue("widgetName2");
        data[1][1]=fr.getPropertyValue("widgetDes2");
        data[1][2]=fr.getPropertyValue("Filter2");
        return data;
    }

    public Object[][] testData() throws IOException {
        Object [] [] data = new Object [2] [7];
        data[0][0]= fr.getPropertyValue("username1");
        data[0][1]=fr.getPropertyValue("password1");
        data[0][2]= fr.getPropertyValue("DashboardName1");
        data[0][3]=fr.getPropertyValue("DashboardDes1");
        data[0][4]= fr.getPropertyValue("widgetName1");
        data[0][5]=fr.getPropertyValue("widgetDes1");
        data[0][6]=fr.getPropertyValue("Filter1");

        data[1][0]= fr.getPropertyValue("username2");
        data[1][1]=fr.getPropertyValue("password2");
        data[1][2]= fr.getPropertyValue("DashboardName2");
        data[1][3]=fr.getPropertyValue("DashboardDes2");
        data[1][4]= fr.getPropertyValue("widgetName2");
        data[1][5]=fr.getPropertyValue("widgetDes2");
        data[1][6]=fr.getPropertyValue("Filter2");
        return data;
    }


}
