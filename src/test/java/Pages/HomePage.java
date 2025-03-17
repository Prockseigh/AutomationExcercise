package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {
    ElementMethods elementMethods;
    WebDriver driver;
    CommonMethods commonMethods;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.commonMethods = new CommonMethods(driver);

        PageFactory.initElements(driver,this); //se pot indentifica elementele prin @findBy
    }

    @FindBy(xpath = "//p[text()='Consent']")
    WebElement consent;

    @FindBy(xpath = "//*[text()= ' Products']")
    WebElement products;

    @FindBy(xpath = "//*[text()= ' Cart']")
    WebElement cart;

    @FindBy(xpath = "//a [text() = ' Signup / Login']")
    WebElement login;

    @FindBy(xpath = "//*[text()= ' Contact us']")
    WebElement contactUs;

    public void clickOnConsent()
    {   isDisplayed(consent);
        elementMethods.clickOnElement(consent);
        LoggerUtility.infoTest("User clicks on Consent");
    }

    public void clickOnProducts()
    {   isDisplayed(products);
        elementMethods.clickOnElement(products);
    }

    public void clickOnCart()
    {   isDisplayed(cart);
        elementMethods.clickOnElement(cart);
    }

    public void clickOnLogin()
    {   isDisplayed(login);
        elementMethods.clickOnElement(login);
        LoggerUtility.infoTest("User clicks on logIn");
    }

    public void clickOnContactUs()
    {   isDisplayed(contactUs);
        elementMethods.clickOnElement(contactUs);
        LoggerUtility.infoTest("User clicks on Contact Us");
    }
}
