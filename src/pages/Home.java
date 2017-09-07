
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;


   static String URL = "http://demoqa.com/sortable/";


    @FindBy(css = "#sortable > li:nth-child(1)")
    static WebElement sortable1;

    @FindBy(css = "#sortable > li:nth-child(2)")
    static WebElement sortable2;

    @FindBy(css = "#sortable > li:nth-child(5)")
    static WebElement sortable5;


    @FindBy(css = "#sortable > li:nth-child(6)")
    static WebElement sortable6;




    @FindBy(css = "#selectable > li:nth-child(1) ")
    static WebElement topbar;

    @FindBy(css = "#selectable > li:nth-child(7) ")
    static WebElement bottombar;





    @FindBy(id = "draggableview")
    static WebElement draggable;

    @FindBy(className = "title")
   static WebElement title;

    @FindBy(id = "resizable")
    static WebElement resizable;

    @FindBy(css = "#resizable > div:nth-child(4) ")
    static WebElement corner;

    @FindBy(id = "droppableview")
    static WebElement target;


    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
    static WebElement AddUserLink;


    @FindBy(name = "username")
    static WebElement user;

    @FindBy(name = "password")
    static WebElement password;





    public String getURL() {
        return URL;
    }




    public String getTitle() {
        return driver.getTitle();
    }
}