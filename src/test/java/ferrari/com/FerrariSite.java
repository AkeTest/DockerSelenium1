package ferrari.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FerrariSite {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        //set path
        System.setProperty("webdriver.chrome.driver","C:/Users/Akemunise/Documents/TESTER/DOCKER/dockerImage/DRIVERS/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void landFerrari(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToPage();
        loginPage.ClickCookie();
        loginPage.ClickUpdateButton();
    }

    @Test(dependsOnMethods = "landFerrari")
    public void NewsLetterSubscriptions(){
        NewsLetterSubscription newsLetterSubscription = new NewsLetterSubscription(driver);

        newsLetterSubscription.setEmailValue("161222dacasa@test.it");
        newsLetterSubscription.setNewsLetterGt();
//        newsLetterSubscription.setNewsLetterESPORTS();
        newsLetterSubscription.SetPrivacy();
        newsLetterSubscription.setCapthca();
        newsLetterSubscription.clickBtnSubScribe();



    }
}
