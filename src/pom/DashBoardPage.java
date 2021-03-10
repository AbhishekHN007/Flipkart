package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.WebActionUtil;

public class DashBoardPage extends BasePage{
	
	@FindBy(xpath="//div[text()='Mobiles']")private WebElement mobileMenuLink;
	@FindBy(xpath="//div[text()='Electronics']")private WebElement electronicsMenuLink;
	@FindBy(xpath="//div[text()='Fashion']")private WebElement fashionMenuLink;
	@FindBy(linkText="Logout")private WebElement signoutLink;
	
	public WebElement getMobileMenuLink() {
		return mobileMenuLink;
	}
	public WebElement getElectronicsMenuLink() {
		return electronicsMenuLink;
	}
	public WebElement getFashionMenuLink() {
		return fashionMenuLink;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void setSignoutLink(WebElement signoutLink) {
		this.signoutLink = signoutLink;
	}
	
	public DashBoardPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public ProductListPage clickOnLink(String menuItem) {
		switch(menuItem) {
		case "mobile":webActionUtil.clickOnElement(getMobileMenuLink());
						break;
		case "electronics":webActionUtil.clickOnElement(getElectronicsMenuLink());
							break;
		case "fashion" :webActionUtil.clickOnElement(getFashionMenuLink());
						break;
		}
		return new ProductListPage(driver,webActionUtil);
		
	}
	
}
