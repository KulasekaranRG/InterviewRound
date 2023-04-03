package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		// Navigate to the page with multiple frames
		driver.get("https://letcode.in/frame");
		// Set the implicit wait to 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Switch to the first frame by its index
		driver.switchTo().frame(0);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Find an element within the first frame and interact with it
		driver.findElement(By.name("fname")).sendKeys("Kulasekaran");
		driver.findElement(By.name("lname")).sendKeys("RG");
		// Switch to the second frame
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("kulargk04@gmail.com");
		// Switch back to the main content of the page
		driver.switchTo().defaultContent();
		// Quit the browser
		driver.quit();

	}
}
