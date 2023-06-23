package Selenium_Practice_Maven.Selenium_Starter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRatings {
	
	WebDriver driver;
	
	public IMDBRatings() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	public void endTest() {
		driver.close();
		
	}
	
	public void testCase08() {
		driver.get("https://www.imdb.com/chart/top");
		
		List<WebElement> rating = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		
		//How many movies are included in the table?
		System.out.println(rating.size());
		
		//What is the highest rated movie on IMDb?
		float highestRating = Float.MIN_VALUE;
		WebElement result = null;
		
		for(WebElement element : rating) {
			String text = element.getText();
			//System.out.println(text);
			float currentRating = Float.parseFloat(text);
			if(currentRating > highestRating) {
				highestRating = currentRating;
				result = element;
				System.out.println(highestRating);
			}			
		}
		WebElement movieName = result.findElement(By.xpath("preceding-sibling::td[1]")); //tbody/tr/td[3]/preceding-sibling::td[1]
		System.out.println(movieName.getText());		
	}
	
	
	
	//What is the oldest movie on the list?	
	//What is the most recent movie on the list?
	//tbody/tr/td[2]
	
	public void testCase09() {
		driver.get("https://www.imdb.com/chart/top");
		
		WebElement dropdown = driver.findElement(By.id("lister-sort-by-options"));		
		Select select = new Select(dropdown);
		select.selectByVisibleText("Release Date");
		
		List<WebElement> movies = driver.findElements(By.xpath("//tbody/tr/td[2]"));		
		
		String recentMovie = movies.get(0).getText();
		System.out.println(recentMovie);
		
		int oldMovieIndex = movies.size() - 1;
		String oldMovieName = movies.get(oldMovieIndex).getText();
		System.out.println(oldMovieName);
		
	}
	
	//Which movie has the most user ratings?
	public void testCase10() {
		driver.get("https://www.imdb.com/chart/top");
		WebElement dropdown = driver.findElement(By.id("lister-sort-by-options"));		
		Select select = new Select(dropdown);
		select.selectByVisibleText("Number of Ratings");
		
		List<WebElement> movies = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		String userRating = movies.get(0).getText();
		System.out.println(userRating);
	}

}


//driver.get("https://www.imdb.com/chart/top");
//
//List<WebElement> rating = driver.findElements(By.xpath("//tbody/tr/td[3]"));
//
//float highestRating = Float.MIN_VALUE;
//List<WebElement> highestRatedMovies = new ArrayList<>();
//
//for (WebElement element : rating) {
//    String text = element.getText();
//    float currentRating = Float.parseFloat(text);
//
//    if (currentRating > highestRating) {
//        highestRating = currentRating;
//        highestRatedMovies.clear();  // Clear the previous highest rated movies
//    }
//
//    if (currentRating == highestRating) {
//        highestRatedMovies.add(element);
//        System.out.println(highestRating);
//    }
//}
//
//// Check if any movies were found with the highest rating
//if (!highestRatedMovies.isEmpty()) {
//    for (WebElement movie : highestRatedMovies) {
//        WebElement movieName = movie.findElement(By.xpath("./preceding-sibling::td[1]"));
//        System.out.println(movieName.getText());
//    }
//} else {
//    System.out.println("No movies found with the highest rating.");
//}

