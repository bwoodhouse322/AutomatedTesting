import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class k {
    SpreadSheetReader sheetReader;
    WebDriver driver;
    WebElement blockQuote;
    private static ExtentReportManager reportManager;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
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


        ExtentTest testOne = reportManager.setUpTest();
        driver.navigate().to("https://thedemosite.co.uk");
        driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/" +
                "table/tbody/tr/td[2]/p/small/a[3]")).click();
        testOne.log(Status.INFO,"The test navigates to the add a user page and creates a user.");
        testOne.log(Status.DEBUG,"The test navigates to https://thedemosite.co.uk, then clicks on add a user.");

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
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
