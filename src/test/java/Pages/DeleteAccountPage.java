package Pages;

import HelperMethods.ElementMethods;
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
        elementMethods.clickOnElement(deleteAccountButton);
    }

    public void continueAfterDelete()
    {   elementMethods.assertCurrentUrl("https://www.automationexercise.com/delete_account");
        elementMethods.clickOnElement(continueButton);
        elementMethods.assertCurrentUrl("https://www.automationexercise.com/");
    }
}
