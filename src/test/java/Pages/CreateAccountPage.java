package Pages;

import HelperMethods.CommonMethods;
import HelperMethods.ElementMethods;
import ObjectData.CreateAccountObjectData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CreateAccountPage extends CommonMethods
{
        WebDriver driver;
        ElementMethods elementMethods;

    public CreateAccountPage(WebDriver driver)  {
        super(driver);
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
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




    public void completeCreateAccount(CreateAccountObjectData data)
    {
        selectGender(titleMrs,titleMr,"Mr.");
        elementMethods.fillElement(passwordField,data.getPassword());
        elementMethods.fillElement(dayOfBirth,data.getDay());
        Assert.assertTrue(monthOfBirth.isDisplayed());
        selectMonth(data.getMonth());
        elementMethods.fillElement(yearOfBirth,data.getYear());
        checkNewsLetter();
        checkOffers();
        elementMethods.fillElement(firstnameField,data.getFirstName());
        elementMethods.fillElement(lastNameField,data.getLastName());
        elementMethods.fillElement(companyField,data.getCompany());
        elementMethods.fillElement(address1Field,data.getAddress1());
        elementMethods.fillElement(address2Field, data.getAddress2());
        elementMethods.fillElement(country,data.getCountry());
        elementMethods.fillElement(state,data.getState());
        elementMethods.fillElement(city,data.getCity());
        elementMethods.fillElement(zipcode,data.getZipcode());
        elementMethods.fillElement(mobile,data.getMobileNumber());
        createAccount();
        continueButton();


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
