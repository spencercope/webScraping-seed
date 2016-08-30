package webscraper;


public class WebScraper 
{
    public static void main(String[] args) 
    {
        Scraper s = new Scraper();
        s.openSite();
        s.closeBrowser();
    }
    
}
