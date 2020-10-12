package appium.test.apk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appium.test.apk.util.Constant;
import appium.test.apk.util.TestAPKUtil;

public class TestRccClient {
	private static RemoteWebDriver driver;
	
	@BeforeClass
	public void setupEnvironment() throws MalformedURLException {
		DesiredCapabilities capabilities = TestAPKUtil.getPopulatedCapabilities();
		
		capabilities.setCapability("appPackage", "de.blackned.rcsclient");
		// This package name of your app (you can get it from apk info app)
		// This is Launcher login-activity
		capabilities.setCapability("appActivity", "de.blackned.rcsclient.view.general.MainActivity"); 
		
		// pass the environment setup as capabilities to Appium server, it will connect android app.
		driver = new RemoteWebDriver(new URL(Constant.APPIUM_SERVER_URL), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testLoginCase() throws Exception {
		System.out.println("Test Case - 1");

		// locate the email Text on the test android-app by using xpath.
		// de.blackned.rcsclient:id/userNameTextField
		WebElement emailElement = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='de.blackned.rcsclient:id/userNameTextField']"));
		//emailElement.sendKeys("jahenzaib.ali@gmail.com");
		emailElement.sendKeys("demo");
		
		// locate the password Text on the test android-app by using xpath.
		//de.blackned.rcsclient:id/passwordTextField
		WebElement passwordElement = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='de.blackned.rcsclient:id/passwordTextField']"));
		passwordElement.sendKeys("1234");
		
		// locate the login button on the test android-app by using xpath.
		//android.widget.LinearLayout and index = 2
		WebElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id='de.blackned.rcsclient:id/loginButton']"));
//		WebElement loginButton = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='de.blackned.rcsclient:id/loginServerSettingsIcon']"));
		
		// press the login button to login.
		loginButton.click();
	}
	
	@AfterClass
	public void teardown(){
		//to close the app
		//driver.quit();
	}
}
