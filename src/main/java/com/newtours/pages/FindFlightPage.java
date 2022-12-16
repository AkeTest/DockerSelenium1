package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="reserveFlights")
    private WebElement firstSubmitButton;

    @FindBy(id ="input_50_0_0")
    private WebElement emirateChoise;

    @FindBy(id = "input_50_1_1")
    private WebElement quatarChoise;

    @FindBy(id = "input_50_2_2")
    private WebElement britishChoise;

    public FindFlightPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void submitFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmitButton));
        this.firstSubmitButton.click();
    }

    public void emirateChoiseFlight(){
        this.wait.until(ExpectedConditions.visibilityOf(this.emirateChoise));
        this.emirateChoise.click();
    }
    public void quatarChoiseFlight(){
        this.quatarChoise.click();
    }
    public void britishChoiseFlight(){
        this.britishChoise.click();
    }
}
