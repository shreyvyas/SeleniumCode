package Selenium_Practice_Maven.Selenium_Starter;

import java.net.MalformedURLException;

public class App 
{
    public static void main( String[] args ) throws MalformedURLException, InterruptedException
    {
    	App app = new App();
    	app.getGreeting();
        
    }
    
    public void getGreeting() throws InterruptedException, MalformedURLException{
    	
    	SearchAmazon sa = new SearchAmazon();
    	sa.createDriver();
    	//sa.testCase01();
    	//sa.endTest();
    	System.out.println(sa.testCase01());
    	
    }
}
