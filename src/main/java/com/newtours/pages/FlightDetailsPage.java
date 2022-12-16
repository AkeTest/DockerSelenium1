package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "country")
    private WebElement country;

    @FindBy(name = "findFlights")
    private WebElement registerButton;

    @FindBy(name="passCount")
    private WebElement passangersNumber;

    @FindBy(name = "servClass")
    private List<WebElement> radioFirstClass;

    public FlightDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void selectCountry(String selectedCountry){
        this.wait.until(ExpectedConditions.elementToBeClickable(country));
        Select select= new Select(country);
        select.selectByValue(selectedCountry);
    }

    public void RegisterButton(){
        this.registerButton.click();
    }

    public void selectPassangerNumbers(){
        this.wait.until(ExpectedConditions.visibilityOf(this.passangersNumber));
        Select nPassangers = new Select(driver.findElement(By.name("passCount")));
        nPassangers.selectByIndex(1);
    }

    public void selectFirstClass(){
        this.radioFirstClass.get(2).click();
    }
}
