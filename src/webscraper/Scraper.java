package webscraper;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
        

public class Scraper
{
    long sleeper = 2000;
    WebDriver driver;
    String[] urlArray = new String[]{
        "http://www.city-data.com/city/St.-Louis-Missouri.html",                            //once you know the url pattern
        "http://www.city-data.com/city/Chicago-Illinois.html",                              //of the website you want to scrape
        "http://www.city-data.com/city/New-York-New-York.html",                             //you can use excel to concatenate
        "http://www.city-data.com/city/Los-Angeles-California.html",                        //the urls and paste into here
        "http://www.city-data.com/city/Seattle-Washington.html"
    };

    
    public Scraper()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/spencer/Documents/Code/LiveOnGithub/webScraping-seed/lib/chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    public void loopAndGrab()
    {
        for (int i = 0; i < urlArray.length; i++)
        {
            driver.navigate().to(urlArray[i]);
            String educationInfo = driver.findElement(By.id("education-info")).getText();
            System.out.println("\n" + urlArray[i]);
            System.out.println(educationInfo);
        }
    }
    
    public void closeBrowser()
    {
        driver.close();
    }
    
    
    
    //some extra methods that may be helpful for your web scrape
    
    public void login() throws InterruptedException
    {
        
        WebElement usernameElem;
        WebElement passwordElem;
        usernameElem = driver.findElement(By.id("id of username element"));
        passwordElem = driver.findElement(By.id("id of password element"));
        WebElement submitElem = driver.findElement(By.xpath("xPath of submit button"));
        
        usernameElem.sendKeys("your_username");
        passwordElem.sendKeys("your_password");
        sleeper = getRandLong();
        Thread.sleep(sleeper);
        submitElem.click();
    }
    
    public long getRandLong()
    {
        long lowerBound = 2000;
        long upperBound = 6000;
        Random r = new Random();
        
        long randLong = lowerBound + (long)(r.nextDouble()*(upperBound - lowerBound));
        return randLong;
    }
}
