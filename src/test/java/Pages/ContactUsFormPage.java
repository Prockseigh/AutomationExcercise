package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.ContactUsObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
        LoggerUtility.infoTest("Submit buttos is displayed");
        elementMethods.clickOnElement(submitButton);
        alertMethods.alertAccept();
    }



    public void completeContactUsPage(ContactUsObjectData data) {
        elementMethods.clearFillElement(nameField,data.getName());
        LoggerUtility.infoTest("Name was completed");
        elementMethods.clearFillElement(emailField, data.getEmail());
        LoggerUtility.infoTest("Email was completed");
        elementMethods.clearFillElement(subjectField, data.getSubject());
        LoggerUtility.infoTest("Subject was entered");
        elementMethods.clearFillElement(messageField, data.getMessage());
        LoggerUtility.infoTest("Message was completed");
        elementMethods.addFile(uploadFile,"src/test/resources/black1.png");
        LoggerUtility.infoTest("File was added");

    }

}









