package com.raghib.selenium.extension;

/**
 * References:-
 * https://www.youtube.com/watch?v=TOlmh0kz9mc
 * https://www.youtube.com/watch?v=8VdyaEI88oQ
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raghib.selenium.BaseClass;

public class GooglePage extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";

	public static String url = "http://www.google.com";
	public static String googleSearchBox = "//*[@id='APjFqb']";
	public static String linkPath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/a/h3";

	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);

		WebElement element = driver.findElement(By.xpath(googleSearchBox));

		Duration duration = Duration.ofSeconds(30);

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(googleSearchBox)));

		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);

		WebDriverWait wait1 = new WebDriverWait(driver, duration);
		wait1.until(ExpectedConditions.elementToBeClickable((By.xpath(linkPath)))).click();

		// Thread.sleep(5000);
		// BaseClass.quitDriver();
	}
}
