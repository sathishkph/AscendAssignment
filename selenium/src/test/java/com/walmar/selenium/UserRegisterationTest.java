package com.walmar.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegisterationTest {
	
	

	    private WebDriver driver;

	    @Before
	    public void setUp() {
	        // Set up WebDriver (you need to download the ChromeDriver executable and set its path)
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void testRegistration() {
	        // Navigate to the registration page
	        driver.get("https://demoqa.com/register");

	        // Your test logic here
	        WebElement firstNameInput = driver.findElement(By.id("firstName"));
	        firstNameInput.sendKeys("John");

	        WebElement lastNameInput = driver.findElement(By.id("lastName"));
	        lastNameInput.sendKeys("Doe");

	        WebElement usernameInput = driver.findElement(By.id("userName"));
	        usernameInput.sendKeys("john.doe");

	        WebElement passwordInput = driver.findElement(By.id("password"));
	        passwordInput.sendKeys("password123");

	        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
	        confirmPasswordInput.sendKeys("password123");

	        WebElement registerButton = driver.findElement(By.id("register"));
	        registerButton.click();

	        // Example: Verify registration success message
	        WebElement successMessage = driver.findElement(By.cssSelector(".main-header"));
	        assertEquals("Thanks for registering!", successMessage.getText());
	    }

	    @After
	    public void tearDown() {
	        // Close the WebDriver
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


}