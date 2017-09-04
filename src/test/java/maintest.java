import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class maintest {

    WebDriver chrome;
    @Before
    public void setUp(){
        chrome = new ChromeDriver();
    }


    @After
    public void tearDown(){
        chrome.quit();
    }
    @Test
    public void firstTest(){
        chrome.navigate().to("https://www.google.co.uk");
    }
}
