
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNativeCalculator {
	WebDriver driver;

	@BeforeClass
	public void setupEnvironment() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = getPopulatedCapabilities();

		capabilities.setCapability("appPackage", "com.android.calculator2");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of
																							// your app (you can get it
																							// from apk info app)
		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testCalculator() throws Exception {
		// locate the Text on the calculator by using By.name()
		WebElement two = driver.findElement(By.xpath("//android.widget.Button[@text='2']"));
		two.click();
		WebElement plus = driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
		plus.click();
		WebElement four = driver.findElement(By.xpath("//android.widget.Button[@text='4']"));
		four.click();
		WebElement equalTo = driver.findElement(By.xpath("//android.widget.Button[@text='=']"));
		equalTo.click();
		// locate the edit box of the calculator by using By.tagName()
		WebElement results = driver.findElement(By.xpath("//android.widget.TextView[@index='2']"));
		// Check the calculated value on the edit box
		assert results.getText().equals("6")
				: "Actual value is : " + results.getText() + " did not match with expected value: 6";

	}
	

	/**
	 * @throws MalformedURLException
	 */
//	@Test
	public void testRCCLoginScreen() throws MalformedURLException {
		DesiredCapabilities capabilities = getPopulatedCapabilities();
		
		// app name
//		capabilities.setCapability("app", "rcc.apk");
		
		
		capabilities.setCapability("appPackage", "com.example.shiva.try1");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.example.shiva.try1.login"); // This is Launcher activity

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 * @throws MalformedURLException
	 */
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = getPopulatedCapabilities();

		capabilities.setCapability("appPackage", "com.android.chrome");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main"); // This is Launcher activity
																							// of
																							// from apk info app)
		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
	

	@AfterClass
	public void teardown(){
		//close the app
//		driver.quit();
	}
}