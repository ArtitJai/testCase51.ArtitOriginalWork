package utilitiez;

import pageObjects.HomePage;
import pageObjects.LogIn;
import pageObjects.MyAccount;
import pageObjects.Registration;
import pageObjects.Shop;

public class PageInitializer extends BaseClass {

	public static HomePage hp;
	public static LogIn lg;
	public static Registration re;
	public static Shop sp;
	public static MyAccount my;
	
	public static void initialize() {

		hp = new HomePage();
		lg = new LogIn();
		re = new Registration();
		sp = new Shop();
		my = new MyAccount();
	}
}
