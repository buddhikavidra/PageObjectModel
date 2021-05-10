package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.Base;
import pages.CheckoutPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.MainPage;

class TestCaseOne extends Base{

	@Test
	static void testcase(){
		// TODO Auto-generated method stub
		//test(LoginPage.xpath_commonInput("bla bggla"));
		
		GetBrowser("https://www.saucedemo.com/");
		Type(LoginPage.xpath_commonInputById("user-name"),"standard_user");
		Type(LoginPage.xpath_commonInputById("password"),"secret_sauce");
		Click(LoginPage.xpath_commonInputById("login-button"));
		pause(15);
		
		verifyUrl("https://www.saucedemo.com/inventory.html");
		Click(MainPage.xpath_commonText("Sauce Labs Backpack"));
		verifyText(MainPage.xpath_prize("inventory_details_price"), "$29.99");
		verifyText(MainPage.xpath_commonText("Sauce Labs Backpack"), "Sauce Labs Backpack");
		Click(ItemPage.xpath_commonButtonById("add-to-cart-sauce-labs-backpack"));
		Click(MainPage.xpath_LinkById());
		verifyUrl("https://www.saucedemo.com/cart.html");
		
		verifyText(MainPage.xpath_prize("inventory_item_price"), "$29.99");
		verifyText(MainPage.xpath_commonText("Sauce Labs Backpack"), "Sauce Labs Backpack");
		
		Click(ItemPage.xpath_commonButtonById("remove-sauce-labs-backpack"));
		verifyText(MainPage.xpath_commonText("Sauce Labs Backpack"), "Sauce Labs Backpack");
		verifyText(MainPage.xpath_prize("inventory_details_price"), "$29.99");
		Click(ItemPage.xpath_commonButtonById("continue-shopping"));
		
		//
		Click(MainPage.xpath_commonText("Sauce Labs Backpack"));
		verifyText(MainPage.xpath_prize("inventory_details_price"), "$29.99");
		verifyText(MainPage.xpath_commonText("Sauce Labs Backpack"), "Sauce Labs Backpack");
		Click(ItemPage.xpath_commonButtonById("add-to-cart-sauce-labs-backpack"));
		Click(ItemPage.xpath_commonButtonById("back-to-products"));
		Click(MainPage.xpath_commonText("Sauce Labs Bike Light"));
		//
		verifyText(MainPage.xpath_prize("inventory_details_price"), "$9.99");
		verifyText(MainPage.xpath_commonText("Sauce Labs Bike Light"), "Sauce Labs Bike Light");
		Click(ItemPage.xpath_commonButtonById("add-to-cart-sauce-labs-bike-light"));
		//
		Click(MainPage.xpath_LinkById());
		//
		Click(ItemPage.xpath_commonButtonById("checkout"));
		//
		Type(LoginPage.xpath_commonInputById("first-name"),"standard_user");
		Type(LoginPage.xpath_commonInputById("last-name"),"standard_user2");
		Type(LoginPage.xpath_commonInputById("postal-code"),"5848754");
		Click(LoginPage.xpath_commonInputById("continue"));
		///
		Count(CheckoutPage.xpath_ItemCount());
		//
		Click(ItemPage.xpath_commonButtonById("finish"));
		//
		verifyText(CheckoutPage.xpath_Header(), "THANK YOU FOR YOUR ORDER");
		verifyUrl("https://www.saucedemo.com/checkout-complete.html");
		close();
	}

	
	
	
	
}
