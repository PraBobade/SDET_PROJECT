package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _01_LoginPage {
    WebDriver driver;
     public _01_LoginPage(WebDriver dr){
         driver = dr;
         PageFactory.initElements(dr, this);
     }

    @FindBy(name="uid")
    @CacheLookup        // once a element find in page then with help of @CacheLookup then driver store that element and if we use this element
    WebElement textUserName;     // again in webpage then driver again not find for this element it automatically click on it

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText="Log out")
    @CacheLookup
    WebElement Logout;

    public void setUserName(String UName){
        textUserName.sendKeys(UName);
    }
    public void setPasswordName(String PassWord){
        txtPassword.sendKeys(PassWord);
    }
    public void ClickLogin(){
        btnLogin.click();
    }
    public void clickLogout(){Logout.click();}
}
