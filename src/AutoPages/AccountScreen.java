import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountScreen {

    @FindBy(css = "#js-header-nav > a")
    static WebElement logo;

    @FindBy(css = "#vrn")
    static WebElement regno;

    @FindBy(css = "#mileage")
    static WebElement mileage;

    @FindBy(css = "#my-car-vrn-find-details > button")
    static WebElement submit;

    @FindBy(css = "#my-car-confirmation > button > span")
    static  WebElement secondsubmit;

    @FindBy(css = "#my-car-details > div > div.my-autotrader-page-my-car-holder.cf > div.my-autotrader-page-my-car-image > img")
    static WebElement image;

    @FindBy(css = "#manageProfile")
    static WebElement detailsPage;

    @FindBy(css = "body > main > section.my-autotrader-page__main.my-profile-content.my-profile-personal-details.cf > div.myautotrader-personaldetails--personalDetails.myautotrader-personalDetails--signinsetails > div.cf > a")
    static WebElement editbtn;

    @FindBy(css= "#surname")
    static WebElement surname;

    @FindBy(css = "#myautotrader-edit-personal-details > input.button-grey-large")
    static WebElement saveChanges;

    @FindBy(css= "#name")
    static WebElement name;

    @FindBy(css = "#my-car-details > div > div.my-car-actions.cf > div.grid.cf > div:nth-child(3) > a")
    static WebElement delet;
    @FindBy(css= "#my-car-delete-form > div > span.js-submit-delete-my-car-text.button-delete")
    static  WebElement delete;
}
