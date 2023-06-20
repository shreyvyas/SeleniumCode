package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedinPost {
	
	WebDriver driver;
	
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	public void testCase03() throws InterruptedException {
		//open linkedin
		driver.get("https://in.linkedin.com/");
		
			
		//click on Sign in button
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		Thread.sleep(2000);
		
		//enter email address and password
		WebElement email = driver.findElement(By.xpath("//*[@id='session_key']"));
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys("shreyvyas@yahoo.co.in");
		
		WebElement password = driver.findElement(By.id("session_password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("Anagh@2016");
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
	}

}
