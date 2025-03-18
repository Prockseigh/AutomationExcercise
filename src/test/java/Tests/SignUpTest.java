package Tests;

import HelperMethods.ElementMethods;

import Logger.LoggerUtility;
import ObjectData.SignUpObjectData;
import Pages.HomePage;
import Pages.SignUpPage;
import ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class SignUpTest extends Hooks {

    HomePage homePage;
    ElementMethods elementMethods;
    SignUpPage signUpPage;
    private Map<String, SignUpObjectData> signUpObjectDataMap;


    @Test
    public void happyTest()
    {
        signUpObjectDataMap = xmlReader.loadData("src/test/resources/signUpAndInData.xml", SignUpObjectData.class);
        SignUpObjectData data1 =  signUpObjectDataMap.get("dataSet_2");
        homePage = new HomePage(getDriver());
        elementMethods = new ElementMethods(getDriver());
        signUpPage = new SignUpPage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnLogin();
        signUpPage.completeSignUp(data1);



    }

    @Test
    public void negativeTest()
    {

        signUpObjectDataMap = xmlReader.loadData("src/test/resources/signUpAndInData.xml", SignUpObjectData.class);
        SignUpObjectData data =  signUpObjectDataMap.get("dataSet_5");
        homePage = new HomePage(getDriver());
        elementMethods = new ElementMethods(getDriver());
        signUpPage = new SignUpPage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnLogin();
        signUpPage.completeExistingSingUp(data);
        signUpPage.clickOnSignUp();



        WebElement errorEmailMessage = getDriver().findElement(By.xpath("//p[text() = 'Email Address already exist!']"));
        Assert.assertTrue(errorEmailMessage.isDisplayed());
        LoggerUtility.infoTest("Expected error message displayed");
        ChainTestListener.log("Expected error message displayed");
    }




}
