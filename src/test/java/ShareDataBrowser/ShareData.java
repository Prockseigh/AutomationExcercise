package ShareDataBrowser;

import ShareDataBrowser.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;



public class ShareData {
    private WebDriver driver;


    public void initializeBrowser(){
        driver = new BrowserFactory().getBrowserFactory();
        driver.get("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void clearBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
