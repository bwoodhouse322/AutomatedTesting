import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Van {

        @FindBy(css = "#search")
        static WebElement submit;

        @FindBy(css = "#main-content > div.js-search-results > header > div > label > div > div > select")
        static WebElement check;

        @FindBy(css = "#postcode")
        static  WebElement pcode;
}
