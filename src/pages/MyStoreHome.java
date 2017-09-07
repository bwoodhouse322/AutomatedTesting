

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyStoreHome {
    WebDriver driver;

    static String URL = "http://automationpractice.com/index.php?id_category=3&controller=category";

    //TEST ONE
    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a ")
    static WebElement womenButton;


    @FindBy(css = "#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img ")
    static WebElement imagePress;

    @FindBy(css = "   #add_to_cart > button ")
    static WebElement buttonPress;

    @FindBy (css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    static WebElement checkout;

    //TEST TWO
    @FindBy( css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    static WebElement signIn;

    @FindBy( name = "email_create")
    static WebElement emailBox;

    @FindBy(css = "#SubmitCreate")
    static WebElement submitBut;

    @FindBy( css = "#id_gender1")
    static WebElement radiobtn;

    @FindBy(name = "customer_firstname")
    static WebElement fnameBox;

    @FindBy(name = "customer_lastname")
    static WebElement snameBox;

    @FindBy(name = "passwd")
    static WebElement pwordeBox;

    @FindBy(name ="days")
    static WebElement days;

    @FindBy(name ="months")
    static WebElement months;

    @FindBy(name ="years")
    static WebElement years;

    @FindBy(name="address1")
    static WebElement address;

    @FindBy(name="city")
    static WebElement city;

    @FindBy(name="id_state")
    static WebElement state;

    @FindBy(name="postcode")
    static WebElement zip;

    @FindBy(name="id_country")
    static WebElement country;

    @FindBy(name="phone_mobile")
    static WebElement phone;

    @FindBy(css="#submitAccount")
    static WebElement submit2;

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(2) > a")
    static WebElement signOut;

    //TEST THREE

    @FindBy(css = ".layer_cart_product > h2:nth-child(2)")
    static WebElement h2SuccessAddedToCart2;

    @FindBy(css = "span.ajax_cart_quantity:nth-child(2)")
    static WebElement amountInCartNumber2;

    @FindBy(css = ".cross")
    static WebElement xButtonOnConfirmation2;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span")
    static WebElement remove1stFromCart2;

    @FindBy(css = ".shopping_cart > a:nth-child(1)")
    static WebElement cartButton2;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    static WebElement womenButton2;


    @FindBy(css = "#homefeatured > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")
    static WebElement addToCartFadedShortSleeveT2;

    @FindBy(css = "#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")
    static WebElement addToCartBlouse2;

    //TEST FOUR
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    static WebElement cartButton;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    static WebElement checkoutButton;


    @FindBy(css= "#cgv")
    static WebElement checkBox;

    @FindBy(name ="#form > p > button")
    static WebElement submitAgain;

    @FindBy(css= "#email")
    static WebElement usr;

    @FindBy(css= "#passwd")
    static WebElement pwd;

    @FindBy(css= "#SubmitLogin")
    static WebElement sb;

    @FindBy(css= " #center_column > form > p > button")
    static WebElement sb2;

     @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    static WebElement cardpay;

     @FindBy(css= "#cart_navigation > button")
    static WebElement ultraconfirm;


    @FindBy(css = "#form > p > button")
    static WebElement actuallyPress;

    //TEST FIVE

    @FindBy(css = "#newsletter-input")
    static WebElement newsletterBox;

    @FindBy(css = "#newsletter_block_left > div > form > div > button")
    static  WebElement butbut;

    @FindBy(css = "#columns > p")
    static WebElement greenie;








}
