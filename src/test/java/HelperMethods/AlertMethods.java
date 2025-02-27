package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods extends CommonMethods {

    WebDriver driver;
    public AlertMethods(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void alertAccept() {

        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

    }

    public void waitForAlert(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}

