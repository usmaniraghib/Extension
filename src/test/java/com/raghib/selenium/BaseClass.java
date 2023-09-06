package com.raghib.selenium;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass {
	
	public static ChromeOptions chromeOptions;
	public static FirefoxOptions firefoxOptions;
	public static WebDriver driver;
	
	public static String browserArguments1 = "--disable-notifications";
	public static String browserArguments2 = "--remote-allow-origins=*";
	
	public static File singleExtension = new File("./Extensions/SelectorsHub 5.0.1.0.crx");
	public static List<File> multipleExtension = Arrays.asList(new File("./Extensions/SelectorsHub 5.0.1.0.crx"),new File("./Extensions/AdBlock — best ad blocker 5.9.0.0.crx"));
	
	
	public static WebDriver getDriver(String browserName, String browserVersion) {		
		if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} if(browserName.equalsIgnoreCase("firefox")) {
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBrowserVersion(browserVersion);
			firefoxOptions.addArguments(browserArguments1);
			driver = new FirefoxDriver(firefoxOptions);			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.setBrowserVersion(browserVersion);
			chromeOptions.addArguments(browserArguments1,browserArguments2);
			//Way-1
			//chromeOptions.addExtensions(singleExtension);
			//Way-2
			chromeOptions.addExtensions(multipleExtension);
			driver = new ChromeDriver(chromeOptions);
		}
		return driver;		
	}
	
	public static void closeDriver() {
		driver.close();
	}
	
	public static void quitDriver() {
		driver.quit();
	}

}
