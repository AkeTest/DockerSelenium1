package ferrari.com;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;




    @FindBy(partialLinkText = "?")
    private WebElement UpdateButton;



    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieButton;

    @FindBy(xpath = "//iframe[@width='304']")
    public WebElement an05z838fbsn8Iframe;

    @FindBy(css = ".BtnCta__text__16tieEQV")
    public WebElement btnCtatext16tieEQVSpan;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    public void goToPage(){
        driver.get("https://www.ferrari.com/it-IT");
        this.wait.until(ExpectedConditions.visibilityOf(this.cookieButton));
    }

    public void ClickCookie(){
        this.cookieButton.click();
    }

    public void ClickUpdateButton(){
        this.wait.until(ExpectedConditions.visibilityOf(this.UpdateButton));
        this.UpdateButton.click();
    }



}
