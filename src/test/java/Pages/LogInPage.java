package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.LogInObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    ElementMethods elementMethods;
    HomePage homePage;
    CommonMethods commonMethods;



    public LogInPage(WebDriver driver) {

        this.homePage = new HomePage(driver);
        this.elementMethods = new ElementMethods(driver);
        this.commonMethods = new CommonMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;


    public void completeValidLogIn(LogInObjectData data){

        commonMethods.isDisplayed(emailField);
        LoggerUtility.infoTest("Email field is displayed");
        ChainTestListener.log("Email field is displayed");
        elementMethods.clearFillElement(emailField,data.getEmailAddr());
        LoggerUtility.infoTest("Email was filled");
        ChainTestListener.log("Email was filled");
        commonMethods.isDisplayed(passwordField);
        LoggerUtility.infoTest("Password field is displayed");
        ChainTestListener.log("Password field is displayed");
        elementMethods.clearFillElement(passwordField,data.getPassword());
        LoggerUtility.infoTest("Password was filled");
        ChainTestListener.log("Password was filled");
        commonMethods.isDisplayed(loginButton);
        LoggerUtility.infoTest("Login button is displayed");
        ChainTestListener.log("Login button is displayed");
        elementMethods.clickOnElement(loginButton);
        LoggerUtility.infoTest("Login button clicked");
        ChainTestListener.log("Login button was clicked");

    }

    public void completeInvalidLogIN(LogInObjectData data){
        commonMethods.isDisplayed(emailField);
        LoggerUtility.infoTest("Email field is displayed");
        ChainTestListener.log("Email field is displayed");
        elementMethods.clearFillElement(emailField,data.getInvalidEmail());
        LoggerUtility.infoTest("Invalid Email was filled");
        ChainTestListener.log("Email was filled");
        commonMethods.isDisplayed(passwordField);
        LoggerUtility.infoTest("Password field is displayed");
        ChainTestListener.log("Password field displayed");
        elementMethods.clearFillElement(passwordField, data.getInvalidPassword());
        LoggerUtility.infoTest("Invalid Password was filled");
        ChainTestListener.log("Password was filled");
        commonMethods.isDisplayed(loginButton);
        LoggerUtility.infoTest("Login button is displayed");
        ChainTestListener.log("Login button displayed");
        elementMethods.clickOnElement(loginButton);
        LoggerUtility.infoTest("Login button clicked");
        ChainTestListener.log("Login button clicked");




    }
}
