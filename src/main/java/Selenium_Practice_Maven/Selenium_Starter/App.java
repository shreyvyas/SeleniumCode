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
    	
    	//Amazon
//    	SearchAmazon sa = new SearchAmazon();
//    	sa.createDriver();
//    	//sa.testCase01();
//    	//sa.endTest();
//    	System.out.println(sa.testCase01());
    	
    	//number of hyperlinks
    	Hyperlinks hl = new Hyperlinks();
    	hl.createDriver();
    	System.out.println(hl.testCase02());
    	
    }
}
