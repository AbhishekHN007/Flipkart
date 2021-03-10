package pom;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.WebActionUtil;

public class ProductListPage extends BasePage {
	@FindBy(xpath="//input[@placeholder='Search Brand']") private WebElement filterSearchFeild;
	@FindBy(xpath="//div[text()='Apple']") private WebElement itemSearchButton;
	@FindBy(xpath="//div[text()='Apple iPhone 11 (White, 64 GB)']") private WebElement clickOnProduct;
	

	public WebElement getFilterSearchFeild() {
		return filterSearchFeild;
	}

	public WebElement getItemSearchButton() {
		return itemSearchButton;
	}

	public WebElement getClickOnProduct() {
		return clickOnProduct;
	}


	public ProductListPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public ProductDetailPage selectItem(String productName) {
		webActionUtil.enterData(getFilterSearchFeild(), productName);
		webActionUtil.clickOnElement(getItemSearchButton());
		webActionUtil.clickOnElement(getClickOnProduct());
		String wid1 = driver.getWindowHandle();
		 Set<String> wid = driver.getWindowHandles();
			for(String s:wid) {
				if(!wid1.equals(wid)) {
					driver.switchTo().window(s);
				}
			}
			return new ProductDetailPage(driver,webActionUtil);
			
	}

}
