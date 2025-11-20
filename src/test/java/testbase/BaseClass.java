package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
    
    @BeforeClass(groups= {"sanity","Regression"})
    @Parameters({"os","browser"})
    public void Setup(String os,String br) throws IOException {
    	
    	//loading config.propertiesfile 
    	FileReader file=new FileReader("./src//test//resources//config.properties");
    	
    	p=new Properties();
    	p.load(file);
    	
    	//for the loggers 
       logger=LogManager.getLogger(this.getClass());
       
       
       if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
    	   DesiredCapabilities capbilities = new DesiredCapabilities();
    	   //os
    	   
    	   if(os.equalsIgnoreCase("windows")){
    		   capbilities.setPlatform(Platform.WIN11); 
    	   }else if(os.equalsIgnoreCase("mac")) {
    		   capbilities.setPlatform(Platform.MAC); 
    	   }else {
    		   System.out.println("no matching os ");
    	   }   
       
       //browser
       switch(br.toLowerCase()) {
       case "chrome" :capbilities.setBrowserName("chrome");break;
       case "edge" : capbilities.setBrowserName("edge");break;
       case "default" : System.out.println("no matching browser"); return;
       
       
       }
    
       
       if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
    	   
     
       
       //to take the browser setup from the .xml files 
       switch(br.toLowerCase()) {
       case "chrome" : driver=new ChromeDriver();break;
       case "edge" : driver=new EdgeDriver();break;
       case "firefox" : driver=new FirefoxDriver();break;
       case "default" : System.out.println("invalid browser ....."); return;
       
       }
       
       //driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capbilities);
       }
       }
 	  
 	   driver.get(p.getProperty("appUrl"));  //reading url from properties files 
 	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	   
 	   driver.manage().window().maximize();
    }
    public String RandomeString() {
 	   String generatedstring =RandomStringUtils.randomAlphabetic(4);
 	return generatedstring;
 	   
    }
    
    public String RandomeNumber() {
 	   String generatednumber =RandomStringUtils.randomNumeric(4);
 	return generatednumber;
 	   
    }
    
    public String GeneratedPassword() {
 	   String generatedstring =RandomStringUtils.randomAlphabetic(4); 
 	   String generatednumber =RandomStringUtils.randomNumeric(4);
 	   return generatedstring+"@"+generatednumber;
 	   
    }
   @AfterClass(groups= {"sanity","Regression"})
    
    public void TearDown() {
 	   driver.close();
    }
   
   
   public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
    

}
