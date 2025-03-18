package Tests;

import Logger.LoggerUtility;
import ObjectData.CreateAccountObjectData;
import ObjectData.SignUpObjectData;
import Pages.CreateAccountPage;
import Pages.DeleteAccountPage;
import Pages.HomePage;
import Pages.SignUpPage;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.annotations.Test;
import ShareDataBrowser.Hooks;
import xmlReaderUtility.xmlReader;

import java.sql.SQLException;
import java.util.Map;


public class CreateAccountInfoTest extends Hooks {
    SignUpPage signUpPage;
    CreateAccountPage createAccountPage;
    HomePage homePage;
    DeleteAccountPage deleteAccountPage;
    private Map<String,CreateAccountObjectData> createAccountObjectDataMap;
    private Map<String, SignUpObjectData> signUpObjectDataMap;






    @Test
    public void metodaTest() throws SQLException {
        createAccountObjectDataMap = xmlReader.loadData("src/test/resources/createAccountData.xml", CreateAccountObjectData.class);
        signUpObjectDataMap = xmlReader.loadData("src/test/resources/signUpAndInData.xml", SignUpObjectData.class);
        CreateAccountObjectData data = createAccountObjectDataMap.get("dataSet_1");
        SignUpObjectData data1 =  signUpObjectDataMap.get("dataSet_2");
        homePage = new HomePage(getDriver());
        signUpPage = new SignUpPage(getDriver());
        createAccountPage = new CreateAccountPage(getDriver());
        deleteAccountPage = new DeleteAccountPage(getDriver());
        homePage.clickOnConsent();
        homePage.clickOnLogin();
        signUpPage.completeSignUp(data1);
        createAccountPage.completeCreateAccount(data);
        LoggerUtility.infoTest("Account data was filled");
        ChainTestListener.log("Account data was filled");
        deleteAccountPage.clickDeleteAccountButton("gaaa");
        ChainTestListener.log("Delete button was clicked");
        deleteAccountPage.continueAfterDelete();
        ChainTestListener.log("Continue after delete was clicked");


    }
}









