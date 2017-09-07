import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class k {
    SpreadSheetReader sheetReader;
    WebDriver driver;
    WebElement blockQuote;
    private static ExtentReportManager reportManager;

    @Before
    public void setUp() {
        driver = chooseDriver("chrome");
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
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
        String username;
        String password;
        String message;
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Example_Spreadsheet.xlsx");
       username= sheetReader.readRow(0,"sheet1").get(0);
        password= sheetReader.readRow(1,"sheet1").get(0);
        message= sheetReader.readRow(2,"sheet1").get(0);

        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Login.class);
        PageFactory.initElements(driver, AddUser.class);



        ExtentTest testOne = reportManager.setUpTest();


        driver.get(Home.URL);


        Home.AddUserLink.click();
        testOne.log(Status.INFO,"The test navigates to the add a user page and creates a user.");
        testOne.log(Status.DEBUG,"The test navigates to https://thedemosite.co.uk, then clicks on add a user.");


        //Explicit w8
        WebElement myElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("username")));

        //fluentWait

       // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
         //       .withTimeout(30,SECONDS)
           //     .pollingEvery(5, SECONDS)
             //   .ignoring(NoSuchElementException.class);


        Home.user.sendKeys(username);
        Home.password.sendKeys(password);
        driver.findElement(By.name("FormsButton2")).click();
        testOne.log(Status.DEBUG,"The test sends ayaz/ayaz and clicks FormsButton2 button.");

        driver.navigate().to("http://thedemosite.co.uk/login.php");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("FormsButton2")).click();
        testOne.log(Status.INFO,"The test navigates to the login page and attempts to login as that user.");
        testOne.log(Status.DEBUG,"The test goes to the login page, then sends ayaz/ayaz and clicks FormsButton2.");

        blockQuote = driver.findElement(By.cssSelector(".auto-style1 > big:nth-child(6) > blockquote:nth-child(1) > blockquote:nth-child(1) > font:nth-child(1) > center:nth-child(1) > b:nth-child(1)"));

        try{
            Assert.assertEquals(blockQuote.getText(),message);
            testOne.pass("Passed.");
        } catch (AssertionError ae){
            testOne.fail("Failed; RIP");
        }

        testOne.log(Status.INFO,"The test checks if the website declares the test is successful.");

    }
}
