package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_AddNewCustomer {
    WebDriver driver;
    public _02_AddNewCustomer(WebDriver dr){
        driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(name="uid")
    @CacheLookup
    WebElement textUserName;
    public void setUserName(String UName){
        textUserName.sendKeys(UName);
    }

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;
    public void setPasswordName(String PassWord){
        txtPassword.sendKeys(PassWord);
    }

    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement btnLogin;
    public void ClickLogin(){
        btnLogin.click();
    }

    @FindBy(linkText="Log out")
    @CacheLookup
    WebElement Logout;
    public void clickLogout(){
        Logout.click();
    }

    @FindBy(xpath = "//p[@class='heading3']")
    @CacheLookup
    WebElement text;
    public String GetText(){
        return text.getText();
    }

    @FindBy(xpath="//a[normalize-space()='New Customer']")
    @CacheLookup
    WebElement AddNewCustomer;
    public void ClickOnAddNewCustomer(){
        AddNewCustomer.click();
    }

    @FindBy(name="name")
    @CacheLookup
    WebElement AddName;
    public void AddCustomerName(String name){
        AddName.sendKeys(name);
    }

    @FindBy(xpath="//input[@value='f']")
    @CacheLookup
    WebElement Female;
    @FindBy(xpath="//input[@value='m']")
    @CacheLookup
    WebElement Male;
    public void AddGender(String Gender){
        if (Gender.contains("male") || Gender.toUpperCase().contains("M") || Gender.contains("Male")){
            Male.click();}
        else{
            Female.click();
        }
    }

    @FindBy(name="dob")
    @CacheLookup
    WebElement DateOfBirth;
    public void AddDateOfBirth(String day,String month,String Year){
        DateOfBirth.sendKeys(day,month,Year);
    }

    @FindBy(name="addr")
    @CacheLookup
    WebElement Address;
    public void AddAddres(String name){
        Address.sendKeys(name);
    }

    @FindBy(name="city")
    @CacheLookup
    WebElement city;
    public void AddCity(String citys){
        city.sendKeys(citys);
    }

    @FindBy(name="state")
    @CacheLookup
    WebElement state;
    public void AddState(String stat){
        state.sendKeys(stat);
    }

    @FindBy(name="pinno")
    @CacheLookup
    WebElement pins;
    public void AddPin(String pin){
        pins.sendKeys(pin);
    }

    @FindBy(name="telephoneno")
    @CacheLookup
    WebElement tele;
    public void AddNumber(String Numbers){
        tele.sendKeys(Numbers);
    }

    @FindBy(name="emailid")
    @CacheLookup
    WebElement Mail;
    public void AddMail(String mail){
        Mail.sendKeys(mail);
    }

    @FindBy(name="password")
    @CacheLookup
    WebElement password;
    public void AddPassword(String Password){
        password.sendKeys(Password);
    }

    @FindBy(xpath="//input[@name='sub']")
    @CacheLookup
    WebElement submit;
    public void Submit(){
        submit.click();
    }
    @FindBy(css="tbody tr:nth-child(4) td:nth-child(2)")
    @CacheLookup
    WebElement CustomerId;
    public String GetCustomerId(){
        return CustomerId.getText();
    }



}
