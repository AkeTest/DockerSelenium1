package ferrari.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewsLetterSubscription {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "email")
    private WebElement emailValue;

    @FindBy(xpath = "//label[.//*[@id='GT']]//span")
    private WebElement NewsLetterGt;

    @FindBy(id="ESPORTS")
    private WebElement NewsLetterEsports;

    @FindBy(css = "label[for='privacy1-1'] span")
    private WebElement PrivacyNo;

    @FindBy(xpath = "//iframe[@width='304']")
    private WebElement recaptcha;

    @FindBy(className = "NewsletterForm__newschecks__3YfFLAHh")
    private List<WebElement> NewsLetterElements;

    @FindBy(css = "BtnCta__text__16tieEQV")
    public WebElement BtnSubScribe;

    public NewsLetterSubscription(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void setEmailValue(String mail){
        this.wait.until(ExpectedConditions.visibilityOf(this.emailValue));
        this.emailValue.sendKeys(mail);
    }

    public void setNewsLetterGt(){
        this.wait.until(ExpectedConditions.elementToBeClickable(NewsLetterGt));
        this.NewsLetterElements.get(0).click();
    }

    public void setNewsLetterESPORTS(){
        this.NewsLetterEsports.click();
    }

    public void SetPrivacy(){
        this.PrivacyNo.click();
    }

    public void setCapthca(){
        this.wait.until(ExpectedConditions.visibilityOf(recaptcha));
        this.recaptcha.click();
    }

    public void clickBtnSubScribe() {
        this.BtnSubScribe.click();
    }
}
