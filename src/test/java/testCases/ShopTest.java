package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiez.commonMethod;

public class ShopTest extends commonMethod {

	@Test(priority = 1, enabled = false)
	public void shopFilterByPriceFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		sp.moveSlider(sp.rightPriceToggle, sp.maxPriceText);
		sp.filterButton.click();
		Assert.assertTrue(sp.priceRange.isDisplayed());
	}

	@Test(priority = 2, enabled = false)
	public void shopProductCategoriesFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		ScrollByPixel(1100);
		sp.addBookToBasket.click();
		Assert.assertTrue(sp.checkBasket.isDisplayed());
	}

	@Test(priority = 3, enabled = false)
	public void shopDefaultSortingFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		selectDropDownVisibleText(sp.sorting, "Sort by popularity");
		ScrollByPixel(900);
		wait(2);
		Assert.assertTrue(sp.wholePage.isDisplayed());
	}

	@Test(priority = 4, enabled = false)
	public void shopAverageRatingSortingFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		selectDropDownVisibleText(sp.sorting, "Sort by average rating");
		ScrollByPixel(900);
		wait(2);
		Assert.assertTrue(sp.wholePage.isDisplayed());
	}

	@Test(priority = 5, enabled = false)
	public void shopNewnessRatingSortingFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		selectDropDownVisibleText(sp.sorting, "Sort by newness");
		ScrollByPixel(900);
		wait(2);
		Assert.assertTrue(sp.wholePage.isDisplayed());
	}

	@Test(priority = 6, enabled = false)
	public void shopLowToHighSortingFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		selectDropDownVisibleText(sp.sorting, "Sort by price: low to high");
		ScrollByPixel(900);
		wait(2);
		Assert.assertTrue(sp.wholePage.isDisplayed());
	}

	@Test(priority = 7, enabled = false)
	public void shopHighToLowSortingFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		selectDropDownVisibleText(sp.sorting, "Sort by price: high to low");
		ScrollByPixel(900);
		wait(2);
		Assert.assertTrue(sp.wholePage.isDisplayed());
	}

	@Test(priority = 8, enabled = false)
	public void shopReadMoreFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		sp.readMoreButton.click();
		Assert.assertEquals(sp.outOfStock.getText(), "Out of stock");
	}

	@Test(priority = 9, enabled = false)
	public void shopSaleFunctionality() {

		clickTabMenu(re.menuTabs, "Shop");
		sp.saleBookButton.click();
		Assert.assertTrue(sp.fullAndDiscountPrice.isDisplayed());
	}

	@Test(priority = 10, enabled = false)
	public void shopAddToBasketViewBasketFunction() {

		clickTabMenu(re.menuTabs, "Shop");
		ScrollByPixel(1100);
		sp.addBookToBasket.click();
		clickTabMenu(re.menuTabs, "Item");
		sp.verifyPriceWithTax();
		hp.checkoutButton.click();
		hp.fillingInfo();
		hp.clickPayment.click();
		hp.placeOrder.click();
		Assert.assertTrue(hp.orderDetailPage.isDisplayed());
		wait(5);
	}

	@Test(priority = 11, enabled = false)
	public void shopAddToBasketViewBasketThroughItemLink() {

		clickTabMenu(re.menuTabs, "Shop");
		ScrollByPixel(1100);
		sp.addBookToBasket.click();
		clickTabMenu(re.menuTabs, "Item");
		sp.verifyPriceWithTax();
		hp.checkoutButton.click();
		hp.fillingInfo();
		hp.clickPayment.click();
		hp.placeOrder.click();
		Assert.assertTrue(hp.orderDetailPage.isDisplayed());
		wait(5);
	}
	
	@Test(priority = 12, enabled = true)
	public void shopAddToBasketViewBasketTaxFunctionality() {
		
		clickTabMenu(re.menuTabs, "Shop");
		ScrollByPixel(1100);
		sp.addBookToBasket.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.checkoutButton.click();
		hp.fillingInfo();
		wait(3);
		sp.taxRateCheck();
		hp.clickPayment.click();
		hp.placeOrder.click();
		Assert.assertTrue(hp.orderDetailPage.isDisplayed());
	}

}
