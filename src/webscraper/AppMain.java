package webscraper;


public class AppMain 
{
    public static void main(String[] args) 
    {
        Scraper s = new Scraper();
        s.loopAndGrab();
        s.closeBrowser();
    }
    
}
