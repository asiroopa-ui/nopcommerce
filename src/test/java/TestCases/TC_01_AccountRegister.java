package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import testbase.BaseClass;


public class TC_01_AccountRegister extends BaseClass{
       
       
       @Test(groups= {"sanity","Master","Regression"})
       public void AccountRegister() {
    	   HomePage hp=new HomePage(driver);
    	   try {
    	   logger.info("**** starting the test case*******");
    	   hp.Register();
    	   RegisterPage rp=new RegisterPage(driver);
    	   logger.info("entering the details fo the test cases");
    	   
    	   rp.FirstName(RandomeString());
    	   rp.LastName(RandomeString());
    	   rp.Email(RandomeString()+"@gmail.com");
    	   
    	 
    	   String Password =GeneratedPassword();
    	   rp.Password(Password);
    	   rp.confirmpassword((Password));
    	   rp.Registerbutton();   
    	   logger.info("Validating expected message..");
    	   String confmsg = rp.Successmsg();
   		   Assert.assertEquals(confmsg, "Your registration completed", "Confirmation message mismatch");

    	   }catch(Exception e){
    		 
    			logger.error("Test failed: " + e.getMessage());
    			Assert.fail("Test failed: " + e.getMessage());
    	   }
    	   finally {
    		   logger.info("**** test case 01 is successfully exceuted**********");
    	   }
    	   
       }
       
}   
