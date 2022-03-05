package TestCases;

import PageObject._02_AddNewCustomer;
import org.junit.Assert;
import org.testng.annotations.Test;

public class _003_TC_AddNewCustomer extends _00_BaseClass {

    @Test
    public void AddNewCustomer() throws InterruptedException {
        _02_AddNewCustomer NewCustomer = new _02_AddNewCustomer(driver);
        NewCustomer.setUserName(UserName);
        NewCustomer.setPasswordName(password);
        NewCustomer.ClickLogin();
        Log.info("Login Successful");
        NewCustomer.ClickOnAddNewCustomer();
        NewCustomer.AddCustomerName("Pradip");
        NewCustomer.AddAddres("Issrawadi Tq Paithan Dist Aurangabad");
        NewCustomer.AddCity("Aurangabad");
        NewCustomer.AddNumber("6546548545454");
        NewCustomer.AddMail(RandomEmail()+"@gmail.com");
        NewCustomer.AddState("HangKong");
        NewCustomer.AddPassword("pass@65659");
        NewCustomer.AddGender("male");
        NewCustomer.AddDateOfBirth("06", "03","1656");
        NewCustomer.AddPin("956232");
        Thread.sleep(3000);
        Log.info("All Detail filled");
        NewCustomer.Submit();


        if (NewCustomer.GetText().equals("Customer Registered Successfully!!!")){
            Assert.assertTrue(true);
            Log.info("Customer Added Successfully");
            System.out.println("the id of customer is   "+NewCustomer.GetCustomerId());
        }
        else{
            Assert.assertTrue(false);
            Log.error("Customer Adding Failed");
        }
    }


}
