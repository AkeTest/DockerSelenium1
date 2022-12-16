package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationRegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText = "sign-in")//link all'interno del testo
    private WebElement signinLink;

    @FindBy(linkText = "Flights")//link
    private WebElement flightsLink;

    public ConfirmationRegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public void goToFlightDetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.signinLink));
        this.flightsLink.click();
    }
}
