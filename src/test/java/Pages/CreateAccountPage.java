package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.CreateAccountObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dataBase.queries.CreateAccountTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.SQLException;


public class CreateAccountPage extends CommonMethods
{
        WebDriver driver;
        ElementMethods elementMethods;
        CreateAccountTable createAccountTable;

    public CreateAccountPage(WebDriver driver) throws SQLException {
        super(driver);
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        createAccountTable = new CreateAccountTable();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='id_gender1']")
    WebElement titleMr;
    @FindBy(xpath = "//label[@for='id_gender2']")
    WebElement titleMrs;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "days")
    WebElement dayOfBirth;
    @FindBy(id= "months")
    WebElement monthOfBirth;
    @FindBy(id = "years")
    WebElement yearOfBirth;
    @FindBy(id = "newsletter")
    WebElement newsLetter;
    @FindBy(id="optin")
    WebElement offers;
    @FindBy(id = "first_name")
    WebElement firstnameField;
    @FindBy(id = "last_name")
    WebElement lastNameField;
    @FindBy(id = "company")
    WebElement companyField;
    @FindBy(id = "address1" )
    WebElement address1Field;
    @FindBy(id = "address2")
    WebElement address2Field;
    @FindBy(xpath = "//*[@id='country']")
    WebElement country;
    @FindBy(id = "state" )
    WebElement state;
    @FindBy(id = "city" )
    WebElement city;
    @FindBy(id = "zipcode")
    WebElement zipcode;
    @FindBy(id = "mobile_number")
    WebElement mobile;
    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement create;
    @FindBy(xpath = ("//a[text()='Continue']"))
    WebElement continueButton;

    public void addEntryInTable(CreateAccountObjectData data) throws SQLException {
        createAccountTable.insertTableObject(data);
    }

    public void updateEntryInTable(CreateAccountObjectData data, Integer id) throws SQLException {
        createAccountTable.updateEntryById(data, id);
    }


    public void completeCreateAccount(CreateAccountObjectData data) throws SQLException {
        selectGender(titleMrs,titleMr,"Mr.");
        LoggerUtility.infoTest("Mr. clicked");
        ChainTestListener.log("Mr. clicked");

        elementMethods.fillElement(passwordField,data.getPassword());
        LoggerUtility.infoTest("Password was filled");
        ChainTestListener.log("Password was filled");

        elementMethods.fillElement(dayOfBirth,data.getDay());
        LoggerUtility.infoTest("Day was filled");
        ChainTestListener.log("Day was filled");

        Assert.assertTrue(monthOfBirth.isDisplayed());
        LoggerUtility.infoTest("Month displayed");
        ChainTestListener.log("Month displayed");

        elementMethods.fillElement(monthOfBirth,data.getMonth());
        //selectMonth(data.getMonth());
        LoggerUtility.infoTest("month filled");
        ChainTestListener.log("Month filled");

        elementMethods.fillElement(yearOfBirth,data.getYear());
        LoggerUtility.infoTest("Year filled");
        ChainTestListener.log("Year filled");

        checkNewsLetter();
        LoggerUtility.infoTest("Checked newsletter");
        ChainTestListener.log("Checked newsletter");

        checkOffers();
        LoggerUtility.infoTest("Checked offers");
        ChainTestListener.log("Checked offers");

        elementMethods.fillElement(firstnameField,data.getFirstName());
        LoggerUtility.infoTest("First name filled");
        ChainTestListener.log("First name filled");

        elementMethods.fillElement(lastNameField,data.getLastName());
        LoggerUtility.infoTest("Last name filled");
        ChainTestListener.log("Last name filled");

        elementMethods.fillElement(companyField,data.getCompany());
        LoggerUtility.infoTest("Company filled");
        ChainTestListener.log("Company filled");

        elementMethods.fillElement(address1Field,data.getAddress1());
        LoggerUtility.infoTest("Address1 filled");
        ChainTestListener.log("Address1 filled");

        elementMethods.fillElement(address2Field, data.getAddress2());
        LoggerUtility.infoTest("Address 2 filled");
        ChainTestListener.log("Address2 filled");

        elementMethods.fillElement(country,data.getCountry());
        LoggerUtility.infoTest("Country filled");
        ChainTestListener.log("Country filled");

        elementMethods.fillElement(state,data.getState());
        LoggerUtility.infoTest("State filled");
        ChainTestListener.log("State filled");

        elementMethods.fillElement(city,data.getCity());
        LoggerUtility.infoTest("City filled");
        ChainTestListener.log("City filled");

        elementMethods.fillElement(zipcode,data.getZipcode());
        LoggerUtility.infoTest("Zipcode filled");
        ChainTestListener.log("Zipcode filled");

        elementMethods.fillElement(mobile,data.getMobileNumber());


        LoggerUtility.infoTest("Mobile filled");
        ChainTestListener.log("Mobile filled");

        createAccount();
        LoggerUtility.infoTest("Create account clicked");
        ChainTestListener.log("Delete acc button was clicked");

        continueButton();
        LoggerUtility.infoTest("Continue button clicked");
        ChainTestListener.log("Continue button clicked");

    }

    public void selectGender(WebElement element,WebElement element2,String gender) {
        switch (gender) {
            case "Mr.":
                element.click();
                break;
            case "Mrs.":
                element2.click();
                break;
        }
    }

    public void checkNewsLetter ()
    {
        isDisplayed(newsLetter);
        elementMethods.clickOnElement(newsLetter);
        Assert.assertTrue(newsLetter.isSelected());
    }

    public void checkOffers()
    {
        isDisplayed(offers);
        elementMethods.clickOnElement(offers);
        Assert.assertTrue(offers.isSelected());
    }

    public void selectCountry(WebElement element,String text){
        isDisplayed(country);
        while (true){
            String currentText = element.getAttribute("value");
            if (currentText.equals(text)){
                element.sendKeys(Keys.ENTER);
                break;
            }
            element.sendKeys(Keys.ARROW_DOWN);
        }
        Assert.assertTrue(country.getText().contains(text));
    }

    public void createAccount()
    {
       isDisplayed(create);
       elementMethods.clickOnElement(create);
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/account_created");
    }

    public void selectMonth(String month)
    {
        Select select = new Select(monthOfBirth);
        select.selectByValue(month);

    }

    public void continueButton()
    {
       isDisplayed(continueButton);
        elementMethods.clickOnElement(continueButton);
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/");





}
}
