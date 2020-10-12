package appium.test.apk;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Run this java source-code (using selenium), it will open the application in android virtual device through Appium, 
//and it will test login functionality of the dummy application.
public class TestAPK {
	WebDriver driver;
	
	@BeforeClass
	public void setupEnvironment() throws MalformedURLException {
		DesiredCapabilities capabilities = getPopulatedCapabilities();
		
		capabilities.setCapability("appPackage", "com.example.shiva.try1");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.example.shiva.try1.login"); // This is Launcher login-activity

		// pass the environment setup as capabilities to Appium server, it will connect android app.
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	
	/**
	 * @throws Exception
	 */
	@Test(priority = 0)
	public void testLoginCase() throws Exception {
		System.out.println("Test Case - 1");
		// locate the email Text on the test android-app by using xpath.
		WebElement emailElement = driver.findElement(By.xpath("//android.widget.EditText[@index='1']"));
		emailElement.sendKeys("jahenzaib.ali@gmail.com");
		
		// locate the password Text on the test android-app by using xpath.
		WebElement passwordElement = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
		passwordElement.sendKeys("test123");
		
		// locate the login button on the test android-app by using xpath.
		WebElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@index='3']"));
		
		// press the login button to login.
		loginButton.click();
	}
	
	@Test(priority = 1)
	public void testLogout() throws Exception {
		System.out.println("Test Case - 2");
		RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
		String packageName = remoteWebDriver.getCapabilities().getCapability("appPackage").toString();
		String currentActivity = remoteWebDriver.getCapabilities().getCapability("appActivity").toString();
		System.out.println("Package Name :" + packageName);
		System.out.println("Activity Name :" + currentActivity);
		Thread.sleep(10000);
	}
	
	
	@AfterClass
	public void teardown(){
		//close the app
		//driver.quit();
	}
	
	/**
	 * @return
	 */
	private DesiredCapabilities getPopulatedCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "7.1.1");
//		capabilities.setCapability("platformVersion", "4.1.0");
		capabilities.setCapability("platformName", "Android");
		return capabilities;
	}
}
