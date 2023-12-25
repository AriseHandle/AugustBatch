package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.FaceBookLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class FaceBookLoginTest extends BaseTest {
	ExtentReports extentReports;
	ExtentTest test;
	@BeforeTest
	public void configureReports() {
		extentReports=Reports.generateReports();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.openChrome("https://www.facebook.com/");
	}

	@Test
	public void createNewAccountTest() {
		test =extentReports.createTest("createNewAccountTest");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		faceBookLoginPage.clickOnCreateNewAccount();
		faceBookLoginPage.enterFirstName("Arise", driver);
	}
	
	@Test
	public void verifyIfFacebookLogoIsDisplayedOnLoginPage() {
		test=extentReports.createTest("verifyIfFacebookLogoIsDisplayedOnLoginPage");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		boolean result =faceBookLoginPage.isLogoDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(result);
		faceBookLoginPage.enterEmailId("Arise@gmail.com");
		faceBookLoginPage.enterPassword("12345");
		faceBookLoginPage.clickOnLogin();
		System.out.println("thanks you");
		softAssert.assertAll();
	}
	
	@Test (dependsOnMethods = "verifyIfFacebookLogoIsDisplayedOnLoginPage")
	public void verifyLoginPageTitle() {
		test = extentReports.createTest("verifyLoginPageTitle");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		String expectedTitle = "Facebook – log in or sign ";
		
		String actualTitle =driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("post assertion");
	}
	
	@AfterMethod
	public void addTestStatus(ITestResult result) {
		if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
		
	}
	
	@AfterTest
	public void publishReports() {
		extentReports.flush();
	}	
}
