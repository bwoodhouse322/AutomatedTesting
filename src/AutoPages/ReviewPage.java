import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage {

    @FindBy(css = "body > div.content__search-bar > div > form > div:nth-child(1) > select")
    static WebElement model;

    @FindBy(css = "body > div.content__search-bar > div > form > div:nth-child(2) > select")
    static WebElement make;

    @FindBy(css= "body > div.content__search-bar > div > form > button")
    static  WebElement submit;
    @FindBy(css = "body > main > section.content-page__main.cf > article > span.review-page--review-all-text.cf > h2 > a")
    static WebElement review;

    @FindBy(css= "body > main > div.grid-right-mpu.grid-outer.grid-outer-full > div.cut-1-2-mpu > div.review-page__mainimage.tracking-standard-link.js-images-view-gallery > img")
    static  WebElement checkImg;
}
