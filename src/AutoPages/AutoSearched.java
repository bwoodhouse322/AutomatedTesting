import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoSearched {

    @FindBy (css = "#main-content > div.js-search-results > header > div > label > div > div > select")
    static WebElement dropDown;
}
