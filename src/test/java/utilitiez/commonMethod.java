package utilitiez;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class commonMethod extends PageInitializer {

	public static Select select;
	static FakeValuesService fakeValuesService;
	static Faker faker;

	public String getConfig(String key) {
		return BaseClass.getUserProperty(key);
	}

	public String getUser(String key) {
		return BaseClass.getUserProperty(key);
	}

	public static String randomUsername() {
		fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????@gmail.com");
		return email;
	}

	public static String randomPassword() {
		fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String password = fakeValuesService.regexify("[a-z1-9]{10}");
		return password;

	}

	public static String randomFirstName() {
		faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;
	}

	public static String randomLastName() {
		faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}

	public static CharSequence[] randomAddress() {
		faker = new Faker();
		String number = faker.address().buildingNumber();
		String streetName = faker.address().streetName();
		return new CharSequence[] { number, " ", streetName };
	}

	public static String randomCity() {
		faker = new Faker();
		String city = faker.address().city();
		return city;
	}

	public static String randomState() {
		faker = new Faker();
		String state = faker.address().state();
		return state;
	}

	public static String randomZipcode() {
		faker = new Faker();
		String zipcode = faker.address().zipCode();
		return zipcode;
	}

	public static String randomPhoneNumber() {
		fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String phoneNumber = fakeValuesService.regexify("[1-9]{10}");
		return phoneNumber;
	}

	public static String randomSSN() {
		fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String SSN = fakeValuesService.regexify("[1-9]{10}");
		return SSN;
	}
	
	// Convert String to number
	public static double stringToNumber(WebElement element) {
		String textCurrency = element.getText();
		String textPrice = textCurrency.substring(1);
		double discountPrice = Double.parseDouble(textPrice);
		return discountPrice;
	}

	/*
	 * Method that click tab menu
	 */
	public static void clickTabMenu(List<WebElement> menuTabs, String tabName) {

		for (WebElement eachTab : menuTabs) {
			if (eachTab.getText().contains(tabName)) {
				eachTab.click();
				break;
			}
		}
	}

	// select DropDown value
	public static void selectDropDownValue(WebElement element, String textTobeSelected) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {

				if (el.getText().equals(textTobeSelected)) {
					select.selectByValue(textTobeSelected);
					break;
				}

			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// click DropDown
	public void clickDropDown(List<WebElement> element, String selection) {
		List<WebElement> button = new ArrayList<>();
		button = element;
		for (WebElement option : button) {
			if (option.getText().contains(selection)) {
				option.click();
				break;
			}
		}
	}

	// select DropDown by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// task -- create select DropDown by VisibleText

	public static void selectDropDownVisibleText(WebElement element, String textVisibleTobeSelected) {

		try {
			Select select = new Select(element);
			// loop option by for each loop
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(textVisibleTobeSelected)) {
					select.selectByVisibleText(textVisibleTobeSelected);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method that clears and sends key
	 */
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);
	}

	/*
	 * method checks if radio/checkbox is enabled and clicks on it
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (actualValue.equals(value)) {
				el.click();
				break;
			}
		}

	}

	// methods that dismisses alerts and catchs exception if alert is not present

	public static void dismissAlert() {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// create a method that accepts alert
	public static void acceptAlert() {
		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}
	}

	// methods that gets text of alert and catsh exception if alert is not present
	// return type has to be String
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	// sends text to alertbox
	public static void sendAlertText(String str) {
		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(str);
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}
	}

	// iframes
	public static void switchToFrame(String nameOrId) {

		try {
			BaseClass.getDriver().switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// switch by index
	public static void switchToFrame(int index) {

		try {
			BaseClass.getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// switch by element
	public static void switchToFrame(WebElement element) {

		try {
			BaseClass.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// handle windows by switching to child window

	public static void switchToChildWindow() {

		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();
		for (String eachWindow : windows) {
			if (!eachWindow.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(eachWindow);
				break;
			}
		}
	}

	// declaring explicit wait(webdriverwait) and initializing it, and then
	// returning the object
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.implicitWaitSec);
		return wait;
	}

	// waits for element to be clickable
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	// waits for element to be visible
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	// waits for the element to be visible before clicks on it
	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	///// js executer
	// declaring and initializing js object and returning it
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	// java script click element
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);
	}

	// javascript sends text
	public static void jsSentText(WebElement element, String text) {
		String valueText = element.getAttribute("value");
		getJSObject().executeScript("arguments[0].value='" + valueText + "'", text);
	}

	// scroll to element using js
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// scroll by pixel
	public static void ScrollByPixel(int pixel) {
		// positive -- scroll down
		// negative -- scroll up
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	// thread .slee is simplified
	public static void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// hover over == moving your curser on an element
	public static void hover(WebElement element) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.moveToElement(element).build().perform();
	}

	// create a method that dragsAndDrops
	public static void dragsAndDrops(WebElement element, WebElement element2) {
		Actions action = new Actions(BaseClass.getDriver());
		action.dragAndDrop(element, element2).build().perform();
	}

	// create a method that doubleClicks
	public static void doubleClicks(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.doubleClick(element).build().perform();
	}
}

///*
// * Method dropDown
// */
//public static void selectDropDown(WebElement dropDown, int index) {
//	select = new Select(dropDown);
//	select.selectByIndex(index);
//
//}
//
//public static void selectDropDown(WebElement dropDown, String indexName) {
//	select = new Select(dropDown);
//	select.selectByVisibleText(indexName);
//}
