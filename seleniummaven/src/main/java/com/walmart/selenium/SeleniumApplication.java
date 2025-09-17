package com.walmart.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(SeleniumApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Set the path to your webdriver executable (e.g., chromedriver.exe)
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		// Open the browser and navigate to the webpage
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

		// Fill out the form
		driver.findElement(By.id("firstName")).sendKeys("Sathishkumar");
		driver.findElement(By.id("lastName")).sendKeys("PH");
		driver.findElement(By.id("userEmail")).sendKeys("sathishkph@yahoo.com");
		driver.findElement(By.cssSelector("input[name='gender'][value='Male']")).click();
		driver.findElement(By.id("userNumber")).sendKeys("8989890011");

		// Select date of birth
		Select dobYear = new Select(driver.findElement(By.id("dateOfBirthYear")));
		Select dobMonth = new Select(driver.findElement(By.id("dateOfBirthMonth")));
		Select dobDay = new Select(driver.findElement(By.id("dateOfBirthDay")));

		dobYear.selectByValue("1996");
		dobMonth.selectByVisibleText("January");
		dobDay.selectByValue("1");

		// Subjects
		WebElement subjectsInput = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		subjectsInput.sendKeys("Math");
		subjectsInput.sendKeys(Keys.RETURN);

		// Hobbies
		driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']")).click();
		driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2']")).click();

		// Upload Picture
		//driver.findElement(By.id("uploadPicture")).sendKeys("/path/to/your/picture.jpg");

		// Current Address
		driver.findElement(By.id("currentAddress")).sendKeys("10 Asisi Nagar,Chennai,India");

		// State and City
		driver.findElement(By.id("state")).click();
		driver.findElement(By.cssSelector("#state .css-26l3qy-menu div:nth-child(2)")).click();

		driver.findElement(By.id("city")).click();
		driver.findElement(By.cssSelector("#city .css-26l3qy-menu div:nth-child(2)")).click();

		// Submit the form
		driver.findElement(By.id("submit")).click();

		// Wait for a while to see the result
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.quit();
	}
}
