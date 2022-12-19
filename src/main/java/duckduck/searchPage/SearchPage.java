package duckduck.searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(id="search_button_homepage")
    private WebElement searchButton;

    @FindBy(linkText = "Video")
    private WebElement videoLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver =driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToSearchPage(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keywords){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBar));
        this.searchBar.sendKeys(keywords);
        this.searchButton.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videoLink));
        this.videoLink.click();
    }

    public Integer getResult(){
        By by= By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,5));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }

}
