package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//a[@class='ico-register']")
	WebElement btRegister;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath ="//a[normalize-space()='Log out']")
	WebElement btnLogout;
	
	@FindBy(xpath ="//img[@alt='nopCommerce demo store']")
	WebElement logincfrmbutton;
	
	
	public void Register() {
		btRegister.click();
	}
	
	public void login() {
		btnLogin.click();
	}
	
	public void logout() {
		btnLogout.click();
	}
	
	public boolean loginConfirm() {
		
		try{
			return (logincfrmbutton.isDisplayed());
		}catch(Exception e){
			return false;
		}
		
		
	}
	
}
