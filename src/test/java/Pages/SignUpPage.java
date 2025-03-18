package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.SignUpObjectData;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SignUpPage extends CommonMethods {
    ElementMethods elementMethods;
    HomePage homePage;



    public SignUpPage(WebDriver driver) {
        super(driver);

        this.homePage = new HomePage(driver);
        this.elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//input[@type='text']"))
    WebElement nameField;
    @FindBy(xpath = ("//input[@data-qa='signup-email']"))
    WebElement emailField;
    @FindBy(xpath = ("//button[@data-qa='signup-button']"))
    WebElement signupButton;


    public void completeSignUp(SignUpObjectData data) {
        isDisplayed(nameField);
        LoggerUtility.infoTest("Name field displayed");
        ChainTestListener.log("NameField displayed");
        elementMethods.clearFillElement(nameField,data.getNewName());
        LoggerUtility.infoTest("Name field was completed");
        ChainTestListener.log("Name field was completed");
        isDisplayed(emailField);
        LoggerUtility.infoTest("Email was displayed");
        ChainTestListener.log("Email was displayed");
        elementMethods.clearFillElement(emailField,data.getNewEmail());
        LoggerUtility.infoTest("Email was completed");
        ChainTestListener.log("Email was completed");
        isDisplayed(signupButton);
        LoggerUtility.infoTest("SignUp is displayed");
        ChainTestListener.log("SignUp is displayed");
        elementMethods.clickOnElement(signupButton);
        LoggerUtility.infoTest("click on signup");
        ChainTestListener.log("Click on signup");
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/signup");
        LoggerUtility.infoTest("Url expected");
        ChainTestListener.log("Url expected");
    }

    public void completeExistingSingUp(SignUpObjectData data)
    {
        isDisplayed(nameField);
        LoggerUtility.infoTest("Name field displayed");
        ChainTestListener.log("NameField displayed");
        elementMethods.clearFillElement(nameField,data.getExistingName());
        LoggerUtility.infoTest("ExistingName field was completed");
        ChainTestListener.log("ExistingName field was completed");
        isDisplayed(emailField);
        LoggerUtility.infoTest("Email was displayed");
        ChainTestListener.log("Email was displayed");
        elementMethods.clearFillElement(emailField,data.getExistingEmail());
        LoggerUtility.infoTest("ExistingEmail was completed");
        ChainTestListener.log("ExistingEmail was completed");
        clickOnSignUp();
        LoggerUtility.infoTest("click on signup");
        ChainTestListener.log("Click on signup");
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/signup");
        LoggerUtility.infoTest("Url expected");
        ChainTestListener.log("Url expected");
    }

    public void clickOnSignUp() {
        waitForElementVisibility(signupButton,3);
        isDisplayed(signupButton);
        clickJS(signupButton);

    }
}
