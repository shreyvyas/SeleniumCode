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
//    	Hyperlinks hl = new Hyperlinks();
//    	hl.createDriver();
//    	System.out.println(hl.testCase02());
    	
    	//Linkedin Post
//    	LinkedinPost lp = new LinkedinPost();
//    	lp.createDriver();
//    	lp.testCase06();
    	//lp.endTest();
    	
    	//Recommended Movies
//    	Movies movies = new Movies();
//    	movies.createDriver();
//    	movies.testCase05();
    	
    	//Nested Frames
//    	NestedFrames frames = new NestedFrames();
//    	frames.testCase07();
//    	//frames.endTest();
    	
    	//IMDB Ratings
//    	IMDBRatings ir = new IMDBRatings();
//    	ir.testCase08();
//    	ir.testCase09();
//    	ir.testCase10();
    	//ir.endTest();
    	
    	//Window Handling
    	WindowHandle wh = new WindowHandle();
    	wh.openURL();
    	wh.testCase11();
    	//wh.endTest();
    	
    }
}
