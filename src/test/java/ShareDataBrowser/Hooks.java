package ShareDataBrowser;

import Logger.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData{
    String testName;
    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        initializeBrowser();
        LoggerUtility.startTestCase(testName);
    }

    @AfterMethod
    public void clearEnvironment(){
        clearBrowser();
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void finishLogs(){
        LoggerUtility.mergeFilesIntoOne();
    }
}
