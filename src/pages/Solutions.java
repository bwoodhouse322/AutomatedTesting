import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Solutions {
    WebDriver driver;

    @FindBy(className = "model-card__heading")
    WebElement body;

    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div[1]/h1/span")
    WebElement header;

    @FindBy(className = "nav__logo icon icon--ui__logo")
    WebElement logo;

    @FindBy(className = "title")
    WebElement title;

    public Solutions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeader() {
        return header.getText();
    }

    public String getBody() {
        return body.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnLogo() {
        logo.click();
    }

}