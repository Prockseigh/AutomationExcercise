package Tests;

import Logger.LoggerUtility;
import ObjectData.LogInObjectData;
import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ShareDataBrowser.Hooks;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class LoginTest extends Hooks{

    HomePage homePage;
    LogInPage logInPage;
    private Map<String, LogInObjectData> logInObjectDataMap;



    @Test
 //happyTest
    public void happyTest()
    {
        logInObjectDataMap = xmlReader.loadData("src/test/resources/signUpAndInData.xml", LogInObjectData.class);
        LogInObjectData dataValid =  logInObjectDataMap.get("dataSet_3");
        logInPage = new LogInPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnLogin();
        logInPage.completeValidLogIn(dataValid);


    }

    @Test
    public void negativeTest(){

        logInObjectDataMap = xmlReader.loadData("src/test/resources/signUpAndInData.xml", LogInObjectData.class);
        LogInObjectData dataInvalid =  logInObjectDataMap.get("dataSet_4");
        logInPage = new LogInPage(getDriver());
        homePage = new HomePage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnLogin();
        logInPage.completeInvalidLogIN(dataInvalid);



        WebElement errorMessage = getDriver().findElement(By.xpath("//p[text() = 'Your email or password is incorrect!']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        LoggerUtility.infoTest("Error message is displayed");
    }




}


