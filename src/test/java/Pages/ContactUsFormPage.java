package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.ContactUsObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsFormPage {
    WebDriver driver;
    ElementMethods elementMethods;
    AlertMethods alertMethods;
    CommonMethods commonMethods;


    public ContactUsFormPage(WebDriver driver){
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.commonMethods = new CommonMethods(driver);

        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath ="//*[@name='name']" )
    WebElement nameField;
    @FindBy(xpath ="//*[@name='email']" )
    WebElement emailField;
    @FindBy(xpath = "//*[@name='subject']")
    WebElement subjectField;
    @FindBy(id = "message")
    WebElement messageField;
    @FindBy(xpath ="//input[@type='file']" )
    WebElement uploadFile;
    @FindBy(xpath = "//*[@value='Submit']")
    WebElement submitButton;

    public void submitContact() {
        commonMethods.isDisplayed(submitButton);
        LoggerUtility.infoTest("Submit buttons is displayed");
        elementMethods.clickOnElement(submitButton);
        LoggerUtility.infoTest("Form was submitted");
        ChainTestListener.log("Form was submitted");
        alertMethods.alertAccept();
        LoggerUtility.infoTest("Alert accepted");
        ChainTestListener.log("Alert accepted");
    }

    public void completeContactUsPage(ContactUsObjectData data) {
        elementMethods.clearFillElement(nameField,data.getName());
        LoggerUtility.infoTest("Name was completed");
        ChainTestListener.log("Name was completed");
        elementMethods.clearFillElement(emailField, data.getEmail());
        LoggerUtility.infoTest("Email was completed");
        ChainTestListener.log("Email was completed");
        elementMethods.clearFillElement(subjectField, data.getSubject());
        LoggerUtility.infoTest("Subject was entered");
        ChainTestListener.log("Subject was entered");
        elementMethods.clearFillElement(messageField, data.getMessage());
        LoggerUtility.infoTest("Message was completed");
        ChainTestListener.log("Message was completed");
        elementMethods.addFile(uploadFile,"src/test/resources/black1.png");
        LoggerUtility.infoTest("File was added");
        ChainTestListener.log("File was added");

    }

}









