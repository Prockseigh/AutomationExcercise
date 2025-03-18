package Pages;

import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
    WebDriver driver;
    ElementMethods elementMethods;
    HomePage homePage;

    public DeleteAccountPage(WebDriver driver)
    {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='fa fa-trash-o']")
    WebElement deleteAccountButton;
    @FindBy (xpath = "//*[text()= 'Continue']")
    WebElement continueButton;
    @FindBy (xpath = "//a[text()=' Logged in as ']")
    WebElement accountNameDisplay;

    public void clickDeleteAccountButton(String text)
    {   elementMethods.textModificationAssert(accountNameDisplay,text);
        LoggerUtility.infoTest("Text was modified");
        ChainTestListener.log("Text was modified");
        elementMethods.clickOnElement(deleteAccountButton);
        LoggerUtility.infoTest("Delete acc button was clicked");
        ChainTestListener.log("Delete acc button was clicked");
    }

    public void continueAfterDelete()
    {   elementMethods.assertCurrentUrl("https://www.automationexercise.com/delete_account");
        LoggerUtility.infoTest("Valid url");
        ChainTestListener.log("Valid url");
        elementMethods.clickOnElement(continueButton);
        LoggerUtility.infoTest("Continue button was clicked");
        ChainTestListener.log("Continue button was clicked");
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/");
        LoggerUtility.infoTest("Expected url");
        ChainTestListener.log("Expected url");
    }
}
