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

    
    public Scraper()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/spencer/Documents/Code/WebScraper/lib/chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    public void openSite()
    {
        driver.navigate().to("http://www.city-data.com/city/St.-Louis-Missouri.html");
    }
    
        public void login() throws InterruptedException
    {
        
        WebElement usernameElem;
        WebElement passwordElem;
        usernameElem = driver.findElement(By.id("username"));
        passwordElem = driver.findElement(By.id("password"));
        WebElement submitElem = driver.findElement(By.xpath("Xpath"));
        
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
    
    
    public void closeBrowser()
    {
        driver.close();
    }
    
}