package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiez.commonMethod;

public class MyAccountTest extends commonMethod {

	@Test(priority = 1, enabled = false)
	public void myAccountDashboard() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		Assert.assertTrue(re.regisHomePage.isDisplayed());
	}

	@Test(priority = 2, enabled = false)
	public void myAccountOrders() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Orders");
		Assert.assertTrue(my.viewOrderPage.isDisplayed());
	}

	@Test(priority = 3, enabled = false)
	public void myAccountViewOrders() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Orders");
		my.viewButton.click();
		Assert.assertTrue(my.orderDetail.isDisplayed());
	}

	@Test(priority = 4, enabled = false)
	public void myAccountStatusOrder() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Orders");
		my.viewButton.click();
		Assert.assertTrue(my.orderDetail.isDisplayed());
	}

	@Test(priority = 5, enabled = false)
	public void myAccountAddressesFunctionality() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Addresses");
		Assert.assertTrue(my.billing.isDisplayed() && my.shipping.isDisplayed());
	}

	@Test(priority = 6, enabled = false)
	public void myAccountEditShipping() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Addresses");
		my.shippingEdit.click();
		my.fillingInfoShipping();
		my.saveShippingAddress.click();
		my.addressChangeText();
	}

	@Test(priority = 7, enabled = false)
	public void myAccountsAccountDetail() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Account Details");
		Assert.assertTrue(my.saveChangeButton.isDisplayed());
	}
	
	@Test(priority = 8, enabled = true)
	public void myAccountsLogOut() {

		clickTabMenu(re.menuTabs, "My Account");
		lg.userLogIn.sendKeys(getUser("email"));
		lg.passwordLogIn.sendKeys(getUser("password"), Keys.ENTER);
		clickTabMenu(re.menuTabs, "My Account");
		clickTabMenu(my.dashboardTab, "Logout");
		Assert.assertTrue(my.afterLogOut.isDisplayed());
	}
}
