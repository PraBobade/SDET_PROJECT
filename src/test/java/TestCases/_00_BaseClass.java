package TestCases;

import Utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class _00_BaseClass {

    ReadConfig read = new ReadConfig();

    public String baseURL = read.getURL();
    public String UserName = read.getUserName();
    public String password = read.getPassword();
    public static WebDriver driver;
    public static Logger Log;


    @BeforeClass
    public void setup(){
        Log = Logger.getLogger("eBanking");  //Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");

        if (read.GetBrowser().contains("hrome")){
            System.setProperty("webdriver.chrome.driver",read.getChromeDriverPath());
            driver = new ChromeDriver();
        }
        if (read.GetBrowser().contains("nternetExplorer")){
            System.setProperty("webdriver.ie.driver", read.getIEDriverPath());
            driver = new InternetExplorerDriver();
        }
        if (read.GetBrowser().contains("dge")){
            System.setProperty("webdriver.edge.driver", read.getEdgeDriverPath());
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }
    public static void ScreenShot(WebDriver driver, String path) throws IOException {
        File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sc, new File(path));
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }



    public String RandomEmail(){
        Random rand = new Random();
        String CapitalAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallAlpha   = "abcdefghijklmnopqrstuvwxyz";
        String RandomString ="";
        int length = 8;
        char ch[] = new char[length];
        for (int i=0;i<length;i++){
            if (rand.nextInt(25)%2==0) {
                ch[i] = CapitalAlpha.charAt(rand.nextInt(25));
                RandomString += (ch[i]);
            }
            else{
                ch[i]=SmallAlpha.charAt(rand.nextInt(25));
                RandomString += (ch[i]);
            }
        }
        for (int i=0;i<4;i++){
            int n = rand.nextInt(9);
            RandomString += (Integer.toString(n));
        }
        return RandomString;
    }


}
