package Tests;

import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.ContactUsObjectData;

import Pages.ContactUsFormPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;


public class ContactUsFormTest extends Hooks {

    HomePage homePage;
    ContactUsFormPage contactUsFormPage;
    ElementMethods elementMethods;
    private Map<String, ContactUsObjectData> contactUsObjectDataMap;

    @Test

    public void metodaTest(){
        contactUsObjectDataMap = xmlReader.loadData("src/test/resources/contactUsData.xml", ContactUsObjectData.class);
        ContactUsObjectData data1 =  contactUsObjectDataMap.get("dataSet_2");
        homePage = new HomePage(getDriver());
        contactUsFormPage = new ContactUsFormPage(getDriver());
        elementMethods = new ElementMethods(getDriver());
        homePage.clickOnConsent();
        LoggerUtility.infoTest("User clicks on consent");
        homePage.clickOnContactUs();
        contactUsFormPage.completeContactUsPage(data1);
        LoggerUtility.infoTest("User completes contactUsPage steps");
        contactUsFormPage.submitContact();
        LoggerUtility.infoTest("Form was submited");



        WebElement contactSuccess = getDriver().findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(contactSuccess.isDisplayed());
    }
}
