package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiez.commonMethod;

public class RegistrationTest extends commonMethod{

	@Test(priority = 1, enabled = true)
	public void registrationSignIn() {
		
		clickTabMenu(re.menuTabs, "My Account");
		re.regisEmail.sendKeys(getUser("email"));
		re.regisPass.sendKeys(getUser("password"));
		re.regisButton.click();
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}
	
	@Test(priority = 2, enabled = true)
	public void registrationWithInvalidEmailID() {
		
		clickTabMenu(re.menuTabs, "My Account");
		re.regisEmail.sendKeys(getUser("invalidEmail"));
		re.regisPass.sendKeys(getUser("password"));
		re.regisButton.click();
		Assert.assertTrue(re.invisibleErrorText.isDisplayed());
	}
	
	@Test(priority = 3, enabled = true)
	public void registrationWithEmptyEmailID() {
		
		clickTabMenu(re.menuTabs, "My Account");
		re.regisPass.sendKeys(getUser("password"));
		re.regisButton.click();
		wait(3);
		Assert.assertTrue(re.errorText.isDisplayed());
	}
	
	@Test(priority = 4, enabled = true)
	public void registrationWithEmptyPassword() {
		
		clickTabMenu(re.menuTabs, "My Account");
		re.regisEmail.sendKeys(getUser("email"));
		re.regisButton.click();
		wait(3);
		Assert.assertTrue(re.errorText.isDisplayed());
	}
	
	@Test(priority = 5, enabled = true)
	public void registrationWithInvalidEmailIDAndPassword() {
		
		clickTabMenu(re.menuTabs, "My Account");
		re.regisButton.click();
		wait(3);
		Assert.assertTrue(re.errorText.isDisplayed());
	}
	
}
