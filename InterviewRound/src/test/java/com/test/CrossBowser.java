package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBowser {
	WebDriver driver;
	@Parameters({ "browser" })
	@BeforeMethod
	public void SetUp(String browsername) {
		switch (browsername) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			break;

		}
	}

	@Test
	public void Test() {
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys("kula@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1234567");
		driver.findElement(By.id("loginbutton")).click();
	}

	@AfterMethod
	private void Quit() {
		driver.quit();
	}

}
