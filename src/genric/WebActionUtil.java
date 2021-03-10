package genric;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;

	public WebActionUtil(WebDriver driver,long ETO) {
		this.driver=driver;
		js= (JavascriptExecutor)driver;
		actions=new Actions(driver);	
	}
	
	public void enterData(WebElement targetElement,String keysToEnter) {
		targetElement.clear();
		targetElement.sendKeys(keysToEnter);
	}
	public void enterDataUsingJs(WebElement targetElement,String keysToEnter ) {
		js.executeScript("arguments[0].value="+keysToEnter+";", targetElement);
	}
	
	public void clickOnElement(WebElement targetElement) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(targetElement));
	}
	public void clickOnElementUsingJs(WebElement targetElement) {
		js.executeScript("arguments[0]click();", targetElement);
	}
	
	public void moveToElement(WebElement targetElement) {
		actions.moveToElement(targetElement).perform();
	}
	
	public void doubleClick(WebElement targetElement) {
		actions.doubleClick(targetElement).perform();
	}
	
	public void contextClick(WebElement targetElement) {
		actions.contextClick(targetElement).perform();
	}
	
	public void dragAndDrop(WebElement sourceElement,WebElement destElement) {
		actions.dragAndDrop(sourceElement, destElement).perform();
	}
	
	public void selectVisisbleText(WebElement targetListBoxElement,String text) {
		Select s=new Select(targetListBoxElement);
		s.selectByVisibleText(text);
	}
	
	public void switchToFrame(String indexNameOrId) {
		try {
		int index=Integer.parseInt(indexNameOrId);
		driver.switchTo().frame(index);
		}catch(NumberFormatException e) {
			driver.switchTo().frame(indexNameOrId);
		}
	}

}
