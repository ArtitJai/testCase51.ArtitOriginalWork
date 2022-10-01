package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiez.commonMethod;

public class LogInTest extends commonMethod {

	@Test(priority = 1, enabled = true)
	public void logInWithValidUsernameAndPassword() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}

	@Test(priority = 2, enabled = true)
	public void logInWithIncorrectUsernameAndIncorrectPassword() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(randomUsername());
		lg.passwordLogIn.sendKeys(randomPassword(), Keys.ENTER);
		Assert.assertTrue(re.errorText.isDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void logInWithCorrectUsernameAndEmptyPassword() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"), Keys.ENTER);
		Assert.assertTrue(re.errorText.isDisplayed());
	}
	
	@Test(priority = 4, enabled = true)
	public void logInWithEmptyUsernameAndValidPassword() {
		
		clickTabMenu(re.menuTabs, "My Account");
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}
	
	@Test(priority = 5, enabled = true)
	public void logInWithEmptyUsernameAndEmptyPassword() {
		
		clickTabMenu(re.menuTabs, "My Account");
		lg.logInButton.click();
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}	
	
	@Test(priority = 6, enabled = true)
	public void passwordShouldMask() {
		
		clickTabMenu(re.menuTabs, "My Account");
		lg.passwordLogIn.sendKeys(getUser("password"));
		Assert.assertTrue(lg.paswordMask.isDisplayed());
	}
	
	@Test(priority = 7, enabled = true)
	public void caseSensitive() {
		
		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("emailSensitive"));
		lg.passwordLogIn.sendKeys(getUser("passwordSensitive"), Keys.ENTER);
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}

	@Test(priority = 8, enabled = true)
	public void logInAuthentication() {
		
		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("emailSensitive"));
		lg.passwordLogIn.sendKeys(getUser("passwordSensitive"), Keys.ENTER);
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}
}
