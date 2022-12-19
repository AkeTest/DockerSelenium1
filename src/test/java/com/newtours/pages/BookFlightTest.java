package com.newtours.pages;

import BaseConfig.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    @Test
    public void registrationPageTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserCredential("selenium","docker");
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.submit();
    }

    @Test (dependsOnMethods = "registrationPageTest")
    public void registrationConfirmation(){
        ConfirmationRegistrationPage confirmationRegistrationPage = new ConfirmationRegistrationPage(driver);
        confirmationRegistrationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    @Parameters({"noOfPassangers"})
    public void flightDetailPage(Integer noOfPassangers) {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassangerNumbers(noOfPassangers);
        flightDetailsPage.selectFirstClass();
        flightDetailsPage.RegisterButton();
    }

    @Test(dependsOnMethods = "flightDetailPage")
    public void findFlightPAGE(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.emirateChoiseFlight();
        findFlightPage.quatarChoiseFlight();
        findFlightPage.britishChoiseFlight();
        findFlightPage.submitFlightPage();
    }

    @Test(dependsOnMethods = "findFlightPAGE")
    public void addBllingAdressFlight(){
            FlightBillingAddress flightBillingAddress = new FlightBillingAddress(driver);
            flightBillingAddress.setStreetAddress("Test");
            flightBillingAddress.setStreetAddress2("test2");
            flightBillingAddress.setCity("testCity");
            flightBillingAddress.setProvince("PRO");
            flightBillingAddress.setPostalCode("123");
            flightBillingAddress.goToOrderConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPAGE")
    @Parameters({"expectedPrice"})
    public void flightCofnirmationPage(String expectedPrice){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice =flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
