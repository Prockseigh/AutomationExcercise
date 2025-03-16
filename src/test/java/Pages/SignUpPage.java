package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import ObjectData.SignUpObjectData;
import org.openqa.selenium.JavascriptExecutor;
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
        elementMethods.clearFillElement(nameField,data.getNewName());
        isDisplayed(emailField);
        elementMethods.clearFillElement(emailField,data.getNewEmail());
        isDisplayed(signupButton);
        elementMethods.clickOnElement(signupButton);
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/signup");
    }

    public void completeExistingSingUp(SignUpObjectData data)
    {
        isDisplayed(nameField);
        elementMethods.clearFillElement(nameField,data.getExistingName());
        isDisplayed(emailField);
        elementMethods.clearFillElement(emailField,data.getExistingEmail());
        clickOnSignUp();
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/signup");
    }



    public void clickOnSignUp() {
        waitForElementVisibility(signupButton,3);
        isDisplayed(signupButton);
        clickJS(signupButton);

    }
}
