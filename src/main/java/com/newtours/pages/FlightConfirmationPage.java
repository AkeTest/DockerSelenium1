package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightCofnrimationHeader; //trove n elemento

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;//trova più elementi

    public FlightConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void printConfirmation(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightCofnrimationHeader));
        System.out.println(this.prices.get(1).getText());
    }
}