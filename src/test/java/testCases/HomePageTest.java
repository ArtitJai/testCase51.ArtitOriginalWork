package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilitiez.commonMethod;

public class HomePageTest extends commonMethod {

	@Test(priority = 1, enabled = false)
	public void homePageWithThreeSliderOnly() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		Assert.assertEquals(hp.sizeOfSliders(), 3);
	}

	@Test(priority = 2, enabled = false)
	public void HomePageWithThreeArrivals() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		Assert.assertEquals(hp.sizeOfArrivals(), 3);
	}

	@Test(priority = 3, enabled = false)
	public void HomePageImagesInArrivalsShouldNavigate() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		Assert.assertTrue(hp.productImage.isDisplayed());
	}

	@Test(priority = 4, enabled = false)
	public void HomePageArrivalsImagesDescription() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		Assert.assertTrue(hp.productDescription.isDisplayed());
	}

	@Test(priority = 5, enabled = false)
	public void HomePageArrivalsImagesReviews() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.clickDescriptionOrReview("REVIEWS");
		Assert.assertTrue(hp.reviewText.isDisplayed());
	}

	@Test(priority = 6, enabled = false)
	public void homepageArrivalsImagesAddToBasket() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		hp.viewMenuItemWithPriceElementDisplayed();
	}

	@Test(priority = 7, enabled = false)
	public void homePageArrivalAddToBasketWithMoreBooks() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		sendText(hp.addProductNumber, getUser("bookItems"));
		hp.addRubyToCartButton.click();
		hp.addRubyToCartButton.click();
		Assert.assertTrue(hp.errorAddItem.isDisplayed());
	}

	@Test(priority = 8, enabled = false)
	public void homeArrivalAddToBasketItems() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		Assert.assertTrue(hp.checkOutPage.isDisplayed());
	}

	@Test(priority = 9, enabled = true)
	public void homeArrivalAddToBasketItemsCoupon() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.couponCodeBox.sendKeys(getUser("discountCode"));
		hp.applyCoupon.click();
		hp.discountCode();
	}

	@Test(priority = 10, enabled = false)
	public void homeArrivalAddToBasketItemsCouponValueLessThan450() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImage"));
		hp.addMasteringToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.couponCodeBox.sendKeys(getUser("discountCode"));
		hp.applyCoupon.click();
		Assert.assertTrue(hp.canNotApplyCode.isDisplayed());
	}

	@Test(priority = 11, enabled = false)
	public void homeArrivalAddToBasketItemsRemoveBook() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.removeBook.click();
		Assert.assertTrue(hp.removeBookText.isDisplayed());
	}

	@Test(priority = 12, enabled = false)
	public void homeArrivalAddToBasketItemsAddBook() {

		clickTabMenu(re.menuTabs, "Shop");
		hp.homeButton.click();
		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		sendText(hp.addQuanity, "3");
		hp.updateBasket.click();
		Assert.assertTrue(hp.addBasket.isDisplayed());
	}

	@Test(priority = 13, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutBookFinalPrice() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.verifyTotal();
	}

	@Test(priority = 14, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutUpdateBasket() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		sendText(hp.addQuanity, "2");
		hp.updateBasket.click();
		Assert.assertTrue(hp.addBasket.isDisplayed());
	}

	@Test(priority = 15, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutTotalAndSubTotalCondition() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.verifySubTotal();
		hp.verifyTotal();
	}

	@Test(priority = 16, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutFunctionality() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.checkoutButton.click();
		Assert.assertTrue(hp.billingDetail.isDisplayed());
	}

	@Test(priority = 17, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutPaymentGateway() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.checkoutButton.click();
		hp.enterCodeButton.click();
		hp.couponCodeBox.sendKeys(getUser("discountCode"));
		hp.checkoutCouponButton.click();
		Assert.assertTrue(hp.checkoutCouponApply.isDisplayed());
		hp.fillingInfo();
		hp.clickPayment.click();
		Assert.assertTrue(hp.orderReview.isDisplayed());
	}

	@Test(priority = 18, enabled = false)
	public void homeArrivalAddToBasketItemsCheckoutPaymentGatewayPlaceOrder() {

		hp.clickNewArrivalBooks(getUser("bookImg"));
		hp.addRubyToCartButton.click();
		clickTabMenu(re.menuTabs, "Item");
		hp.checkoutButton.click();
		hp.enterCodeButton.click();
		hp.couponCodeBox.sendKeys(getUser("discountCode"));
		hp.checkoutCouponButton.click();
		Assert.assertTrue(hp.checkoutCouponApply.isDisplayed());
		hp.fillingInfo();
		hp.clickPayment.click();
		hp.placeOrder.click();
		Assert.assertTrue(hp.orderDetailPage.isDisplayed());
	}
}
