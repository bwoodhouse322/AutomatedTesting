import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutoSign {

    @FindBy (css ="#js-social__signup-tab")
    static WebElement signUpbtn;

    @FindBy (css ="#email")
    static WebElement email;

    @FindBy (css ="#password")
    static WebElement passwd;

    @FindBy (css = "#likeToReceiveThirdPartyServices")
    static WebElement checkBox;

    @FindBy(css = "#social--signup--submit")
    static WebElement submitbtn;

    @FindBy(css = "#signInSubmit")
    static  WebElement signinbtn;

    @FindBy(css= "#signin-email")
    static WebElement email2;

    @FindBy(css= "#signin-password")
    static WebElement passwd2;





}
