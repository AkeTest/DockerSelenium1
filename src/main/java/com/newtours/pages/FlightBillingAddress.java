package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightBillingAddress {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q53_address[addr_line1]")
    private WebElement StreetAddress;

    @FindBy(name="q53_address[addr_line2]")
    private WebElement StreetAddress2;

    @FindBy(name ="q53_address[city]")
    private WebElement City;

    @FindBy(name="q53_address[state]")
    private WebElement Province;

    @FindBy(name="q53_address[postal]")
    private WebElement PostalCode;

    @FindBy(name="buyFlights")
    private WebElement SecondSubmitBtn;

    public FlightBillingAddress(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void setStreetAddress(String streetAddress) {
        this.wait.until(ExpectedConditions.visibilityOf(this.City));
        this.StreetAddress.sendKeys(streetAddress);
    }
    public void setStreetAddress2(String streetAddress2){
        this.StreetAddress2.sendKeys(streetAddress2);
    }

    public void setCity(String city) {
        this.City.sendKeys(city);
    }

    public void setProvince(String province){
        this.Province.sendKeys(province);
    }

    public void setPostalCode(String postalcode){
        this.PostalCode.sendKeys(postalcode);
    }

    public void goToOrderConfirmationPage(){
        this.SecondSubmitBtn.click();
    }
}
