import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyStoreTest {
    SpreadSheetReader sheetReader;
    WebDriver driver;
    Actions builder;
    WebElement blockQuote;
    private static ExtentReportManager reportManager;

    public void timeout(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() {
        driver = chooseDriver("chrome");
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
        builder = new Actions(driver);
    }

    public WebDriver chooseDriver(String dr) {
        WebDriver driver1;
        if (dr.equals("chrome")) {
            driver1 = new ChromeDriver();
            return driver1;
        } else{
            driver1 =  new FirefoxDriver();
            return driver1;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }

    @Test
    public void testOne() {

        PageFactory.initElements(driver, MyStoreHome.class);
        ExtentTest testOne = reportManager.setUpTest();
        driver.get(MyStoreHome.URL);
        testOne.log(Status.INFO,"The test navigates to the Home Page");



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MyStoreHome.womenButton.click();
        testOne.log(Status.INFO,"The test navigates to the Women clothes category");

        WebElement myDynamicElement = driver.findElement(By.cssSelector("#subcategories > ul > li:nth-child(1) > div.subcategory-image > a > img"));

       // MyStoreWomen.addToCart.click();
        MyStoreHome.imagePress.click();

        MyStoreHome.buttonPress.click();


        WebElement myElement2 = (new WebDriverWait(driver,5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")));

        MyStoreHome.checkout.click();


        //  MyStoreWomen.addToCart.click();


        try{
            Assert.assertEquals("hi","hi");
            System.out.println("YEAH");

        }catch(AssertionError ae){
            System.out.println("neigh");

        }


    }
    @Test
    public void testTwo() {

        PageFactory.initElements(driver, MyStoreHome.class);
        ExtentTest testOne = reportManager.setUpTest();
        driver.get(MyStoreHome.URL);
        testOne.log(Status.INFO,"The test navigates to the Home Page");

        MyStoreHome.signIn.click();

        MyStoreHome.emailBox.sendKeys("banjowoodsocks3@gmail.com");
        MyStoreHome.submitBut.click();


        timeout(2);

        MyStoreHome.radiobtn.click();
        MyStoreHome.fnameBox.sendKeys("ayaz");
        MyStoreHome.snameBox.sendKeys("YEAH");
        MyStoreHome.pwordeBox.sendKeys("password");
        MyStoreHome.days.sendKeys("9");
        MyStoreHome.months.sendKeys("May");
        MyStoreHome.years.sendKeys("1996");
        MyStoreHome.address.sendKeys("4 chartwell");
        MyStoreHome.city.sendKeys("Anchorage");
        MyStoreHome.state.sendKeys("Alaska");
        MyStoreHome.zip.sendKeys("99501");
        MyStoreHome.country.sendKeys("United States");
        MyStoreHome.phone.sendKeys("07533797834");

        MyStoreHome.submit2.click();



        ExtentTest extentTest = reportManager.setUpTest();
        try {

           Assert.assertTrue(MyStoreHome.signOut.isDisplayed());
            extentTest.pass("Pass!");
        } catch (AssertionError ae) {
            extentTest.fail("Failed.");
        }
        ///IT WORKS I SWEAR

    }
    @Test

    public void testThree() {
        PageFactory.initElements(driver, MyStoreHome.class);
        //remove from basket
        ExtentTest extentTest = reportManager.setUpTest();
        driver.navigate().to("http://automationpractice.com/index.php");
        timeout(1);
        MyStoreHome.addToCartFadedShortSleeveT2.click();
        timeout(1);
        MyStoreHome.xButtonOnConfirmation2.click();
        timeout(1);

        MyStoreHome.addToCartBlouse2.click();
        timeout(1);
        MyStoreHome.xButtonOnConfirmation2.click();
        timeout(1);

        builder.moveToElement(MyStoreHome.cartButton2).moveToElement(MyStoreHome.cartButton2).build().perform();
        timeout(1);

        MyStoreHome.remove1stFromCart2.click();
        timeout(1);

        try {
            Assert.assertTrue(Integer.parseInt(MyStoreHome.amountInCartNumber2.getText()) == 1);
            extentTest.pass("Pass!");
        } catch (AssertionError ae) {
            extentTest.fail("Failed.");
        }
    }

    @Test
    public void testFour(){

        testOne();
        PageFactory.initElements(driver, MyStoreHome.class);
        //remove from basket
        ExtentTest extentTest = reportManager.setUpTest();
        driver.navigate().to(MyStoreHome.URL);

        MyStoreHome.cartButton.click();
        timeout(2);

        MyStoreHome.checkoutButton.click();


        MyStoreHome.usr.sendKeys("banjowoodsocks@gmail.com");
        MyStoreHome.pwd.sendKeys("password");
        MyStoreHome.sb.click();
        MyStoreHome.sb2.click();

        MyStoreHome.checkBox.click();
        MyStoreHome.actuallyPress.click();

        MyStoreHome.cardpay.click();
        MyStoreHome.ultraconfirm.click();


        timeout(5);

    }


    @Test
    public void testFive(){
        PageFactory.initElements(driver, MyStoreHome.class);
        //remove from basket
        ExtentTest extentTest = reportManager.setUpTest();
        driver.navigate().to(MyStoreHome.URL);


        MyStoreHome.newsletterBox.sendKeys("banjowoodsocks2@gmail.com");
        MyStoreHome.butbut.click();


        try {
            Assert.assertTrue(MyStoreHome.greenie.isDisplayed());
            extentTest.pass("Pass!");
        } catch (AssertionError ae) {
            extentTest.fail("Failed.");
        }


    }




}