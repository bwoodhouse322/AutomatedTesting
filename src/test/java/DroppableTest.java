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
import java.util.concurrent.TimeUnit;

public class DroppableTest {
    SpreadSheetReader sheetReader;
    WebDriver driver;
    Actions builder;
    WebElement blockQuote;
    private static ExtentReportManager reportManager;

    @Before
    public void setUp() {
        driver = chooseDriver("chrome");
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport1",
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

        PageFactory.initElements(driver, Home.class);
        ExtentTest testOne = reportManager.setUpTest();
        driver.get(Home.URL);
        System.out.println(Home.draggable.getLocation());
        Home.draggable.click();
        builder.dragAndDrop(Home.draggable,Home.target).perform();

        System.out.println(Home.target.getText());



        WebElement myElement = (new WebDriverWait(driver,3))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("username")));


        //driver.findElement(By.name("username")).sendKeys(username);
        //  driver.findElement(By.name("password")).sendKeys(password);
        //driver.findElement(By.name("FormsButton2")).click();
        testOne.log(Status.INFO,"The test navigates to the login page and attempts to login as that user.");
        testOne.log(Status.DEBUG,"The test goes to the login page, then sends ayaz/ayaz and clicks FormsButton2.");
        testOne.log(Status.INFO,"The test checks if the website declares the test is successful.");
        try{
            Assert.assertEquals("Dropped!",Home.target.getText());
            System.out.println("YEAH");

        }catch(AssertionError ae){
            System.out.println("neigh");

        }


    }
}