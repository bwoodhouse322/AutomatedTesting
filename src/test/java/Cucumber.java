import cucumber.api.PendingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java8.En;



public class Cucumber implements En {
    public Cucumber() {
        Given("i want to visit", (String url) -> {
            WebDriver driver  = new ChromeDriver();
            driver.navigate().to(url);
        });
        When("i click the sign in button",() ->{

           throw new PendingException();
        });
        Then("i am taken to the sign in page",() -> {

           throw new PendingException();
        });
    }
}

