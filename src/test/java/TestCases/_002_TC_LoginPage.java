package TestCases;


import java.io.IOException;
import java.util.Objects;

import PageObject._01_LoginPage;
import Utilities.excelFile;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class _002_TC_LoginPage extends _00_BaseClass {

    @Test(dataProvider = "LoginData")
    public void LogInDiffData(String username, String pass) throws InterruptedException {
        System.out.println(username+"  "+ pass);
        _01_LoginPage lp = new _01_LoginPage(driver);
        lp.setUserName(username);
        lp.setPasswordName(pass);
        Log.info("UserName and Password is submitted");   // User or Password is not valid
        lp.ClickLogin();
        Log.info("Clicked on Login");
        Thread.sleep(3000);

        if(isAlertPresent()) {  // this alert Come when password is wrong
            Assert.assertEquals("User or Password is not valid", driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Log.warn("Login failed");

        }
        else {
            lp.clickLogout();
            Log.info("LogOut Successfully");
            Thread.sleep(3000);
            driver.switchTo().alert().accept();  //close logout alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(true);
        }
    }
    public boolean isAlertPresent(){ //user defined method created to check alert is present or not
        try {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e) {
            return false;
        }}


  @DataProvider(name="LoginData")
  public static Object[][] LoginData() throws IOException {
          return excelFile.UserName();
  }









}