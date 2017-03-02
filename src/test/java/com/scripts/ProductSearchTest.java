package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.library.BaseLib;
import com.library.GenericLib;
import com.library.ParallelBaseLib;
import com.library.TestngListners;
import com.po.ProductSearchPo;
import com.relevantcodes.extentreports.LogStatus;

public class ProductSearchTest extends BaseLib {
	ProductSearchPo productsearchpo;
	BaseLib baselib;
	TestngListners testnglistners;
	ITestResult result;
	@Test(priority = 1,enabled=true, description = "Search for a product, Add the product to 'cart' and move the product to 'Wishlist'")
	public void addWishlist() throws Throwable {

		productsearchpo = new ProductSearchPo(driver);
		loadURL("https://www.flipkart.com/");
		productsearchpo.getEleSearchField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForMotoE3Power"));
		productsearchpo.getEleSearchButton().click();
		Thread.sleep(5000);
		productsearchpo.getEleMotoE3PowerMobile().click();
		Thread.sleep(3000);
		productsearchpo.getEleAddToCartButton().click();
		Thread.sleep(3000);
		// Assert.assertEquals("Product added to cart successfully.",
		// productsearchpo.getEleProductAddedToCartMsg());
		System.out.println("The Count of items in the cart are :" + productsearchpo.getEleCartCount().getText());
		productsearchpo.getEleCartButton().click();
		Thread.sleep(3000);
		System.out.println(productsearchpo.getEleCartCountInCartPage());
		productsearchpo.getEleMoveToWislistLink().click();
	
}
		


	@Test(priority = 2, enabled=true, description = "Search for a product, Add the product to 'cart', Search for the same product and remove the product to 'Cart'")
	public void addAndRemove() throws Throwable {
	
		productsearchpo = new ProductSearchPo(driver);
		loadURL("https://www.flipkart.com/");
		productsearchpo.getEleSearchField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForMotoE3Power"));
		productsearchpo.getEleSearchButton().click();
		Thread.sleep(5000);
		productsearchpo.getEleMotoE3PowerMobile().click();
		productsearchpo.getEleAddToCartButton().click();
		Thread.sleep(3000);
		System.out.println("The Count of items in the cart are :" + productsearchpo.getEleCartCount().getText());
		productsearchpo.getEleCartButton().click();
		Thread.sleep(3000);
		productsearchpo.getEleContinueShopping().click();
		productsearchpo.getEleSearchField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForMotoE3Power"));
		productsearchpo.getEleSearchButton().click();
		productsearchpo.getEleMotoE3PowerMobile().click();
		productsearchpo.getEleGoToCartButton().click();
		productsearchpo.getEleRemoveLink().click();
		
	}

	@Test(priority = 3, enabled=true, description = "Compare 4 Mobiles, Remove one mobile from comparision, scroll the page, click on cotact Us link in the footer part")
	public void compareFunctionality() throws Throwable {

		productsearchpo = new ProductSearchPo(driver);
		loadURL("https://www.flipkart.com/");
		productsearchpo.clickCompare(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForMotoE3Power"));
		Thread.sleep(2000);
		productsearchpo.getEleSearchField().clear();
		productsearchpo.clickCompare(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForsamsungmobiles"));
		Thread.sleep(2000);
		productsearchpo.getEleSearchField().clear();
		productsearchpo.clickCompare(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForlenovomobile"));
		Thread.sleep(2000);
		productsearchpo.getEleSearchField().clear();
		productsearchpo.clickCompare(GenericLib.getCongigValue(GenericLib.sConfigFile, "searchForlg"));
		Thread.sleep(2000);
		productsearchpo.getEleCompareButton().click();
		Thread.sleep(4000);
		productsearchpo.getEleShowDifferenceCheckBox().click();
		Thread.sleep(2000);
		productsearchpo.getEleRemoveIcon().click();
		Thread.sleep(2000);
		productsearchpo.pageScrollDown();
		Thread.sleep(2000);
		Thread.sleep(2000);
		productsearchpo.pageScrollForEle(productsearchpo.getEleContactUsLink());
		Thread.sleep(3000);
		productsearchpo.ClickByJs(productsearchpo.getEleContactUsLink());
}

	@Test(priority = 4, enabled=true, description = "Filter the Products")
	public void applyFilter() throws Throwable {

		productsearchpo = new ProductSearchPo(driver);
		loadURL("https://www.flipkart.com/");
		productsearchpo.getEleSearchField().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "SearchForMobile"));
		productsearchpo.getEleSearchButton().click();
		Thread.sleep(2000);
		productsearchpo.selectByPrice(productsearchpo.getEleMinPrice(), 2);
		Thread.sleep(6000);
		productsearchpo.selectByPrice(productsearchpo.getEleMaxPrice(), 2);
		Thread.sleep(6000);
		productsearchpo.pageScrollForEle(productsearchpo.getEleSelByBrand());
		Thread.sleep(2000);
		productsearchpo.getEleSelByBrand().click();
		Thread.sleep(6000);
		productsearchpo.pageScrollDown();
		Thread.sleep(2000);
		productsearchpo.getEleSelScreenSize().click();
		productsearchpo.getElePickScreeenSize().click();
		productsearchpo.getEleSelProduct().click();
		Thread.sleep(3000);
		productsearchpo.getEleAddToCartButton().click();
	}
}
