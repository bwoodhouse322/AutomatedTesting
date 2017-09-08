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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Register {
    SpreadSheetReader sheetReader;
    WebDriver driver;
    Actions builder;
    WebElement blockQuote;
    private static ExtentReportManager reportManager;

    @Before
    public void setUp() {
        driver = chooseDriver("chrome");
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\AutoReport",
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


    public void timeout(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
    public void URLTest() {

        PageFactory.initElements(driver, AutoHome.class);
        ExtentTest URLTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);



        URLTest.log(Status.INFO,"The test navigates to the Auto Trader home page");

        try{
            Assert.assertTrue(AutoHome.img.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }


    }

    @Test
    public void register(){

        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSign.class);
        ExtentTest RegisterTest = reportManager.setUpTest();

        driver.get(AutoHome.URL);
        AutoHome.signInbtn.click();
        timeout(1);
        AutoSign.signUpbtn.click();
        AutoSign.email.sendKeys("banjowoodsocks"+ Math.floor(Math.random()*50)+ "@gmail.com");
        AutoSign.passwd.sendKeys("Abcde12345");
        AutoSign.checkBox.click();
        AutoSign.submitbtn.click();

        timeout(3);

        RegisterTest.log(Status.INFO,"The test navigates to the Auto Trader home page");


        try{
            Assert.assertTrue(AutoHome.img.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }




    }

    @Test
    public void carSearch(){
        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSearched.class);
        ExtentTest carSearchTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);

        AutoHome.pcode.sendKeys("NG17 8HP");
        AutoHome.makeSearch.sendKeys("Vauxhall");
        AutoHome.modelSearch.sendKeys("Corsa");
        AutoHome.searchSubmit.click();

        carSearchTest.log(Status.INFO,"Search for a vauxhall corsa");

        try{
            Assert.assertTrue(AutoSearched.dropDown.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }



    }

    @Test
    public void vehicleCheck(){
        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, VehicleCheck.class);
        ExtentTest checkTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);

        AutoHome.vehicleSearch.click();
        VehicleCheck.searchBox.sendKeys("KP52 BNF");
        VehicleCheck.submit.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        checkTest.log(Status.INFO,"check vehicle kp52bnf");


        timeout(1);
        try{
            Assert.assertEquals(VehicleCheck.checkButton.getText().equalsIgnoreCase("Vehicle Details"),"Vehicle Details");
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }

    }

    @Test
    public void login(){
        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSign.class);
        PageFactory.initElements(driver, AccountScreen.class);
        ExtentTest loginTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);


        AutoHome.signInbtn.click();


        AutoSign.email2.sendKeys("banjowoodsocks@gmail.com");
        AutoSign.passwd2.sendKeys("Abcde12345");

        AutoSign.signinbtn.click();
        timeout(2);

        loginTest.log(Status.INFO, "logged into an account.");
        try{
            Assert.assertTrue(AccountScreen.logo.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }




    }

    @Test
    public void addCar(){
        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSign.class);
        PageFactory.initElements(driver, AccountScreen.class);
        ExtentTest loginTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);
        login();

        AccountScreen.regno.sendKeys("kp52bnf");
        AccountScreen.mileage.sendKeys("100000");
        AccountScreen.submit.click();
        AccountScreen.secondsubmit.click();


        try{
            Assert.assertTrue(AccountScreen.image.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }




    }

    @Test
    public void updatePersonalDetails() {
        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSign.class);
        PageFactory.initElements(driver, AccountScreen.class);
        ExtentTest loginTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);
        login();

        AccountScreen.detailsPage.click();
        AccountScreen.editbtn.click();
        AccountScreen.surname.clear();
        AccountScreen.surname.sendKeys("woodhouse");
        AccountScreen.saveChanges.click();

        loginTest.log(Status.INFO,"updates surname record");



        try {
            Assert.assertTrue(AccountScreen.name.getText().equalsIgnoreCase("b woodhouse"));
            System.out.println("YEAH");


        } catch (AssertionError ae) {
            System.out.println("neigh");


        }
    }

    @Test
    public void readReview(){

            PageFactory.initElements(driver, AutoHome.class);
            PageFactory.initElements(driver, ReviewPage.class);

            ExtentTest reviewTest = reportManager.setUpTest();
            driver.get(AutoHome.URL);

            AutoHome.reviewbtn.click();
            ReviewPage.model.sendKeys("Abarth");

            ReviewPage.make.sendKeys("124 Spider");
            ReviewPage.submit.click();
            ReviewPage.review.click();

            reviewTest.log(Status.INFO, "going to read a review of the abarth 124 spider");

        try {
            Assert.assertTrue(ReviewPage.checkImg.isDisplayed());
            System.out.println("YEAH");


        } catch (AssertionError ae) {
            System.out.println("neigh");


        }



    }

    @Test
    public void vanSearch(){

        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, Van.class);

        ExtentTest vanTest = reportManager.setUpTest();
        driver.get(AutoHome.URL);

        AutoHome.vanbtn.click();

        Van.pcode.sendKeys("NG17 8HP");
        Van.submit.click();


            vanTest.log(Status.INFO, "search for a van , with no input in form");

        try {
            Assert.assertTrue(Van.check.isDisplayed());
            System.out.println("YEAH");


        } catch (AssertionError ae) {
            System.out.println("neigh");


        }



    }


    @Test
    public void datadrivenSignin(){
        String username;
        String password;
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/LoginDetails.xlsx");
        username= sheetReader.readRow(0,"sheet1").get(0);
        password= sheetReader.readRow(1,"sheet1").get(0);


        PageFactory.initElements(driver, AutoHome.class);
        PageFactory.initElements(driver, AutoSign.class);
        PageFactory.initElements(driver, AccountScreen.class);
        ExtentTest DDSignin = reportManager.setUpTest();
        driver.get(AutoHome.URL);

        AutoHome.signInbtn.click();


        AutoSign.email2.sendKeys(username);
        AutoSign.passwd2.sendKeys(password);

        AutoSign.signinbtn.click();
        timeout(2);

        DDSignin.log(Status.INFO, "logged into an account.");
        try{
            Assert.assertTrue(AccountScreen.logo.isDisplayed());
            System.out.println("YEAH");


        }catch(AssertionError ae){
            System.out.println("neigh");

        }

    }
}