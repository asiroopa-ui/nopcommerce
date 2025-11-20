package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SignInClass;
import testbase.BaseClass;
import utilities.DataProviders;

public class Tc_03_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"Datadriven"})//getting data provider from differnt class so we are using dataProviderClass=DataProvider.class
	
    public void Loginddt(String email,String pwd,String exp) {
  	  
  	 logger.info("***************tc_03 _test case is started**********************");
  	 try {
  	  HomePage hp= new HomePage(driver);
  	    Thread.sleep(1000);
  	     hp.login();
        SignInClass sc=new SignInClass(driver);
        sc.Email(email);//we are giving in the data formate because in properties file we have data in key and value formate 
        Thread.sleep(1000);
        sc.Password(pwd);
        Thread.sleep(1000);
        sc.login();
        Boolean confirmmsg =hp.loginConfirm();
        System.out.println(confirmmsg);
        if (exp.equalsIgnoreCase("Valid")) {
        	if(confirmmsg==true) {
        		Assert.assertTrue(true);
        		hp.logout();
        	}else {
        		Assert.assertTrue(false);
        	}
        }
        
        if(exp.equalsIgnoreCase("Invalid"))
        {
        	if(confirmmsg==true) {
        		Assert.assertTrue(false);
        		hp.logout();
        	}else {
        		Assert.assertTrue(true);
        	}
        }
        
  	 }catch(Exception e) {
  		 Assert.fail();
  	 }
         
         
         
	}
         
}
