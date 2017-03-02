package com.po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.library.GenericLib;

public class ProductSearchPo {
	WebDriver driver = null;
	public ProductSearchPo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//To identify "Search" field.
	@FindBy(xpath="//input[@class='LM6RPg']")
	private WebElement searchField;
	public WebElement getEleSearchField(){
		   return searchField;
		}	
	// To identify "Moto E3 Power" Mobile 
	@FindBy(xpath="(//div[contains(text(),'Moto E3 Power')])[1]")
	private WebElement eleMotoE3PowerMobile;
	public WebElement getEleMotoE3PowerMobile(){
			return eleMotoE3PowerMobile;
		}
	// To identify "Search" button 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement eleSearchButton;
	public WebElement getEleSearchButton(){
			return eleSearchButton;
		}
	// To identify "Add to Cart" button 
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement eleAddToCartButton;
	public WebElement getEleAddToCartButton(){
			return eleAddToCartButton;
		}
	// To identify "Cart" Button
	@FindBy(xpath="//a[text()='CART']")
	private WebElement eleCartButton;
	public WebElement getEleCartButton(){
			return eleCartButton;
		}
	// To identify the count of items in the "Cart" in home Page 
	@FindBy(xpath="//span[@ class='_2bVfmg']")
	private WebElement eleCartCount;
	public WebElement getEleCartCount(){
			return eleCartCount;
		}	
	// To identify "Count of items in the Cart" of Cart page
	@FindBy(xpath="//span[@ class='_1k-OSK']")
	private WebElement eleCartCountInCartPage;
	public WebElement getEleCartCountInCartPage(){
			return eleCartCountInCartPage;
		}		
	// To identify "Move to wishlist" Link
	@FindBy(xpath="//span[text()='Move to wishlist']")
	private WebElement eleMoveToWislistLink;
	public WebElement getEleMoveToWislistLink(){
			return eleMoveToWislistLink;
		}	
	// To identify "Remove" Link
	@FindBy(xpath="//span[text()='Remove']")
	private WebElement eleRemoveLink;
	public WebElement getEleRemoveLink(){
			return eleRemoveLink;
	}
	// To identify "Continue Shopping" Link
	@FindBy(xpath="//span[text()='Continue shopping']")
	private WebElement eleContinueShopping;
	public WebElement getEleContinueShopping(){
			return eleContinueShopping;
	}	
	// To identify "GO TO CART" button
	@FindBy(xpath="//button[text()='GO TO CART']")
	private WebElement eleGoToCartButton;
	public WebElement getEleGoToCartButton(){
			return eleGoToCartButton;
	}	
	// To identify "Add to Compare " link
	@FindBy(xpath="(//span[text()='Add to Compare'])[1]")
	private WebElement eleAddToCompareLink;
	public WebElement getEleAddToCompare(){
			return eleAddToCompareLink;
	}	
	// To identify "Compare" Button 
	@FindBy(xpath="//span[text()='COMPARE']")
	private WebElement eleCompareButton;
	public WebElement getEleCompareButton(){
			return eleCompareButton;
	}
	// To identify "Remove" icon 
	@FindBy(xpath="(//div[@title='Remove Product'])[4]")
	private WebElement eleRemoveIcon;
	public WebElement getEleRemoveIcon(){
			return eleRemoveIcon;
	}	
	// To identify "Show only differences" Check box 
	@FindBy(xpath="//div[@ class='_1p7h2j']")
	private WebElement eleShowDifferenceCheckBox;
	public WebElement getEleShowDifferenceCheckBox(){
			return eleShowDifferenceCheckBox;
		}	
	// To identify "Contact Us" link 
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement eleContactUsLink;
	public WebElement getEleContactUsLink(){
			return eleContactUsLink;
		}	
	
	// To identify Min Price Dropdown 
	@FindBy(xpath="//div[@class='_1QaKk1']/select")
	private WebElement eleMinPrice;
	public WebElement getEleMinPrice(){
			return eleMinPrice;
		}	
	// To identify Max Price Dropdown 
	@FindBy(xpath="//div[@class='_3nSxeA']/select")
	private WebElement eleMaxPrice;
	public WebElement getEleMaxPrice(){
			return eleMaxPrice;
		}	
	// To identify "Brand" in filter section
	@FindBy(xpath="//div[text()='Apple']")
	private WebElement eleSelByBrand;
	public WebElement getEleSelByBrand(){
			return eleSelByBrand;
		}
	
	// To identify "Primary Camera" in filter section
	@FindBy(xpath="//div[text()='Primary Camera']")
	private WebElement eleSelScreenSize;
	public WebElement getEleSelScreenSize(){
			return eleSelScreenSize;
		}	
	// To Select "Primary Camera" 
	@FindBy(xpath="//div[text()='8 MP & Above']")
	private WebElement elePickScreeenSize;
	public WebElement getElePickScreeenSize(){
			return elePickScreeenSize;
		}	
	// To Select the first product after filtering by price and name
	@FindBy(xpath="(//div[@ class='col zZCdz4'])[1]//div[@class='_1OCn9C']")
	private WebElement eleSelProduct;
	public WebElement getEleSelProduct(){
			return eleSelProduct;
		}	
	
	
	public void clickCompare(String str) throws Throwable{
		
		getEleSearchField().sendKeys(str);
		getEleSearchButton().click();
		getEleAddToCompare().click();
	}
	public void selectByPrice(WebElement element, int indexValue){
		Select select=new Select(element);
		select.selectByIndex(indexValue);
	}
	public void pageScrollDown(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 1500);");
	}
	public void pageScrollForEle(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public void ClickByJs(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);

	}
	// To identify  "Item already present in the cart." error Message
	@FindBy(xpath="//div[text()='Item already present in the cart.']")
	private WebElement eleAlreadyPresentErrMsg;
	public WebElement getEleAlreadyPresentErrMsg(){
			return eleAlreadyPresentErrMsg;
		}
	// To identify "Product added to cart successfully." Message
	@FindBy(xpath="//div[contains(text(),'Product added to cart successfully.')]")
	private WebElement eleProductAddedToCartMsg;
	public WebElement getEleProductAddedToCartMsg(){
			return eleProductAddedToCartMsg;
		}
}
