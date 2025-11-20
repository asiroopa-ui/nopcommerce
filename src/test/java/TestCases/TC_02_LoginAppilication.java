package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SignInClass;
import testbase.BaseClass;

public class TC_02_LoginAppilication extends BaseClass{
      @Test (groups= {"sanity","Master","Regression"})
      public void LoginApplication() {
    	  
    	  logger.info("***************tc_02 _test case is started**********************");
    	  
    	  try {
    	  HomePage hp= new HomePage(driver);
    	  hp.login();
          SignInClass sc=new SignInClass(driver);
          sc.Email(p.getProperty("email"));//we are giving in the data formate because in properties file we have data in key and value formate 
          sc.Password(p.getProperty("password"));
          sc.login();
          
           Boolean confirmmsg =hp.loginConfirm();
           
           hp.logout();
           Assert.assertTrue(confirmmsg);
           
           
    	  }catch(Exception e) {
    		  Assert.fail();
    	  }
          logger.info("*************************tc_02 test case is completed *********************");
      }
}
