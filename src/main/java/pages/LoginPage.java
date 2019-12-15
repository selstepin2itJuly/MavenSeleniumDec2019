package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private static WebDriver dr;
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement user;
	
	@FindBy(name="txtPassword")
	private WebElement pass;
	
	@FindBy(css="input[name='Submit']")
	private WebElement submit;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPass;
	
	private void username(String str) {
		user.sendKeys(str);
	}
	private void password(String str) {
		pass.sendKeys(str);
	}
	public void loginToApp(String sUser, String sPass) {
		user.sendKeys(sUser);
		pass.sendKeys(sPass);
		submit.click();
	}
	
	public void clickOnForgotPassword() {
		forgotPass.click();
	}
}
