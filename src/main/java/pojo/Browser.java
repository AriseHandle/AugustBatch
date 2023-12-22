package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver openChrome(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91877\\OneDrive\\Documents\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		return driver;
	}
}
