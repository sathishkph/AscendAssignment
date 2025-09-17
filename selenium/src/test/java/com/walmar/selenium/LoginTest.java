package com.walmar.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Set the path to your webdriver executable (e.g., chromedriver.exe)
		// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		// Initialize the ChromeDriver instance
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
	}

	@Test
	public void testLogin() {
		// Navigate to the login page

		// Fill out the login form
		WebElement usernameInput = driver.findElement(By.id("userName"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login"));

		usernameInput.sendKeys("testuser");
		passwordInput.sendKeys("Test@123");
		loginButton.click();

		// Wait for a while to see the result
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Perform assertions or additional actions as needed
	}

	/*
	 * @AfterClass public void tearDown() { // Close the browser driver.quit(); }
	 */
}
