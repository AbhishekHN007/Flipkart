package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.WebActionUtil;

public class LoginPage extends BasePage{
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement userNameTextfeild;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement passwordTextfeild;
	
	@FindBy(xpath="//div[@class='_1D1L_j']")
	private WebElement loginButton;
	
	public WebElement getUserNameTextfeild() {
		return userNameTextfeild;
	}

	public WebElement getPasswordTextfeild() {
		return passwordTextfeild;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public LoginPage(WebDriver driver,WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public DashBoardPage login(String userName,String password) {
		webActionUtil.enterData(getUserNameTextfeild(), userName);
		webActionUtil.enterData(getPasswordTextfeild(), password);
		webActionUtil.clickOnElement(getLoginButton());
		return new DashBoardPage(driver,webActionUtil);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
