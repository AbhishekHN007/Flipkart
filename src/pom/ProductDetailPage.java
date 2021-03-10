package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.WebActionUtil;

public class ProductDetailPage extends BasePage {
	@FindBy(xpath="//span[@id='Color']/..//a") private List<WebElement> colorPickerList;
	@FindBy(xpath="//span[@id='Storage']/..//a") private List<WebElement> storagePickerList;
	@FindBy(xpath="//button[text()='ADD TO CART']") private WebElement addToCartButton;
	@FindBy(xpath="//span[text()='Place Order']") private WebElement placeOrderButton;
	@FindBy(xpath="//button[text()='Deliver Here']") private WebElement deliverHereButton;
	@FindBy(xpath="//span[text()='Remove']") private WebElement cartPageRemoveButton;
	@FindBy(xpath="//a[text()='GO TO CART']") private WebElement goToCartButton;
	@FindBy(xpath="//div[text()='Remove']") private WebElement removeButton;
	@FindBy(xpath="//div[text()='Remove']") private WebElement removeAlertButton;
	


	
	public List<WebElement> getColorPickerList() {
		return colorPickerList;
	}

	public List<WebElement> getStoragePickerList() {
		return storagePickerList;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}

	public WebElement getDeliverHereButton() {
		return deliverHereButton;
	}

	public WebElement getCartPageRemoveButton() {
		return cartPageRemoveButton;
	}

	public WebElement getGoToCartButton() {
		return goToCartButton;
	}

	public WebElement getRemoveButton() {
		return removeButton;
	}

	public WebElement getRemoveAlertButton() {
		return removeAlertButton;
	}

	public ProductDetailPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public void clickOnColor(String colorName) {
		for(WebElement ele:getColorPickerList()) {
			if(ele.getAttribute("name").equalsIgnoreCase(colorName)) {
				webActionUtil.clickOnElement(ele);
				break;
			}
		}
	}
	
	public void clickOnRam(String ram) {
		for(WebElement ele:getStoragePickerList()) {
			if(ele.getAttribute("name").equalsIgnoreCase(ram)) {
				webActionUtil.clickOnElement(ele);
				break;
			}
		}
	}
	
	public OrderDeatils ItemDetailPage(String color,String ram) {
		webActionUtil.clickOnElement(getAddToCartButton());
		webActionUtil.clickOnElement(getPlaceOrderButton());
		webActionUtil.clickOnElement(getDeliverHereButton());
		webActionUtil.clickOnElement(getCartPageRemoveButton());
		webActionUtil.clickOnElement(getGoToCartButton());
		webActionUtil.clickOnElement(getRemoveButton());
		webActionUtil.clickOnElement(getRemoveAlertButton());
		return new OrderDeatils(driver,webActionUtil);
		
	}
	

}
