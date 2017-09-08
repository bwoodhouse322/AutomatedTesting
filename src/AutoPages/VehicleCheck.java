import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleCheck {

    @FindBy(css="body > div.vehicle-check > div.parallax-background > section > div > form > span > input")
    static WebElement searchBox;

    @FindBy(css= "body > div.vehicle-check > div.parallax-background > section > div > form > button")
    static  WebElement submit;

    @FindBy(css= "#searchResult > h1")
    static  WebElement checkButton;
}
