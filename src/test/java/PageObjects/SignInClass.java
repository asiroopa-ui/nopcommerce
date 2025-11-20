package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInClass extends BasePage{

	public SignInClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement txtlogin;
	
	public void Email(String email){
		txtEmail.sendKeys(email);
	}
	
	public void Password(String password){
		txtpassword.sendKeys(password);
	}
	
	public void login() {
		txtlogin.click();
	}
	

}
