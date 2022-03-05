package TestCases;

import PageObject._01_LoginPage;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class _001_TC_LoginPage extends _00_BaseClass {
    @Test
    public void LoginValidData() throws IOException {

        Log.info("URL open");
        _01_LoginPage lp = new _01_LoginPage(driver);
        lp.setUserName(UserName);
        lp.setPasswordName(password);
        Log.info("UserName and Password is submitted");
        lp.ClickLogin();
        Log.info("LoginIn Successfully");

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            Log.info("Test Pass ");
        }
        else{
            Assert.assertTrue(false);
            Log.error("Test Failed");
        }

    }
}
