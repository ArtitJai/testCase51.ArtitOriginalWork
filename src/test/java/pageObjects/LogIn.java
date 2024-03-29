package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiez.BaseClass;

public class LogIn {

	public LogIn() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(id = "username")
	public WebElement userLogIn;
	
	@FindBy(id = "password")
	public WebElement passwordLogIn;
	
	@FindBy(xpath = "//*[@id='customer_login']/div[1]/form/p[3]/input[3]")
	public WebElement logInButton;
	
	@FindBy(xpath = "//*[@type='password']")
	public WebElement paswordMask;
}
