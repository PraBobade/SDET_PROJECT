package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try{
        FileInputStream fis = new FileInputStream(src);
        pro = new Properties();
        pro.load(fis);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String getURL(){
        String url = pro.getProperty("baseURL");
        return url;
    }
    public String getUserName(){
        String Name = pro.getProperty("UserName");
        return Name;
    }
    public String getPassword(){
        String Pass = pro.getProperty("passwords");
        return Pass;
    }
    public String getChromeDriverPath(){
        String Chrome = pro.getProperty("Chrome");
        return Chrome;
    }
    public String getIEDriverPath(){
        String FireFox = pro.getProperty("InternetExplorer");
        return FireFox;
    }
    public String getEdgeDriverPath(){
        String Edge = pro.getProperty("Edge");
        return Edge;
    }
    public String GetBrowser(){
        String Edge = pro.getProperty("BrowserName");
        return Edge;
    }
}
