package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txtConfirpassword;
	
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement btnregister;
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement successmsg;
	
	public void FirstName(String fristname){
		txtFirstName.sendKeys(fristname);
	}
	

	public void LastName(String lastname){
		txtLastName.sendKeys(lastname);
	}

	public void Email(String Email){
		txtEmail.sendKeys(Email);
	}

	public void Password(String password){
		txtPassword.sendKeys(password);
	}
	public void confirmpassword(String confirmpassword){
		txtConfirpassword.sendKeys(confirmpassword);
	}
	public void Registerbutton(){
		btnregister.click();
	}
	
	public String Successmsg() {
		return successmsg.getText();
	}
	


}
