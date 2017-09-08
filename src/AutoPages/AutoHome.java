import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoHome {

    static String URL = "http://autotrader.co.uk";

    @FindBy (css = "#js-header-nav")
    static WebElement img;

    @FindBy( css = "#js-header-nav > ul > li.test-header__nav-listing.u-float-right > div.is-not-signed-in > a")
    static WebElement signInbtn;


    @FindBy(css= "#postcode")
    static WebElement pcode;

    @FindBy(css= "#searchVehiclesMake")
    static WebElement makeSearch;

    @FindBy(css= "#searchVehiclesModel")
    static WebElement modelSearch;

    @FindBy(css = "#search > span")
    static WebElement searchSubmit;

    @FindBy(css = "#js-editorial-content > section.products__nav > a:nth-child(4)")
    static WebElement vehicleSearch;

    @FindBy(css = "#js-editorial-content > section.content__nav > a:nth-child(2)")
    static WebElement reviewbtn;

    @FindBy(css = "#home > header > nav.site-header__other-vehicles.js-peek-nav.is-active > ul > li:nth-child(3) > a")
    static WebElement vanbtn;
}
