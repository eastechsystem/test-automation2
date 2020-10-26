package appium.test.apk.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestAPKUtil {
	private static AndroidDriver<WebElement> driver;
	
	/**
	 * @return
	 */
	public static DesiredCapabilities getPopulatedCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		
		capabilities.setCapability("deviceName", "245a01cd04017ece");
		capabilities.setCapability("platformVersion", "10");
		//capabilities.setCapability("deviceName", "Android Emulator");
		//capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformName", "Android");
		
		return capabilities;
	}

	public static AndroidDriver<WebElement> getDriverInstance(String appiumServer, DesiredCapabilities capabilities) throws MalformedURLException {
		 driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
		 return driver;
	}
}
