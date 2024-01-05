package pom;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	@FindBy (xpath = "//input[@id='email']")private WebElement email;
	@FindBy (xpath = "//input[@id='pass']")private WebElement password;
	@FindBy (xpath = "//button[@data-testid='royal_login_button']")private WebElement login;
	@FindBy (xpath = "//a[text()='Forgotten password?']")private WebElement forgotPassword;
	@FindBy (xpath = "//a[@data-testid='open-registration-form-button']")private WebElement createNewAccount;
	@FindBy (xpath = "")private WebElement createAPage;
	@FindBy (xpath = "//input[@name='firstname']") private WebElement firstName;
	@FindBy (xpath = "//img[@class='fb_logo _8ilh img']") private WebElement logo;
	
	public FaceBookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	
	public void facebook1()
	{
		System.out.print("facebook");
	}
	public void enterEmailId(String mailId) {
		email.sendKeys(mailId);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnForgotPassword() {
		forgotPassword.click();
	}
	
	public void clickOnCreateNewAccount() {
		createNewAccount.click();
	}
	
	public void clickOnCreateAPage() {
		createAPage.click();
	}
	
	public void enterFirstName(String name, WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(5000));
		wait.pollingEvery(Duration.ofMillis(200));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		
		firstName.sendKeys(name);
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
}
