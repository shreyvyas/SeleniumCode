package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
	
	WebDriver driver;
	
	public NestedFrames() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	public void testCase07() {
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//left frame
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement leftFrameText = driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
		System.out.println(leftFrameText.getText());
		
		//middle frame
		driver.switchTo().defaultContent();		
		driver.switchTo().frame("frame-top");		
		driver.switchTo().frame("frame-middle");
		WebElement middleFrameText = driver.findElement(By.xpath("//div[contains(text(), 'MIDDLE')]"));
		System.out.println(middleFrameText.getText());
		
		//right frame
		driver.switchTo().defaultContent();		
		driver.switchTo().frame("frame-top");		
		driver.switchTo().frame("frame-right");
		WebElement rightFrameText = driver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]"));
		System.out.println(rightFrameText.getText());
		
		//bottom frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		WebElement bottomFrameText = driver.findElement(By.xpath("//body[contains(text(), 'BOTTOM')]"));
		System.out.println(bottomFrameText.getText());
		
		
	}
	
	public void endTest() {
		driver.quit();
	}

}
