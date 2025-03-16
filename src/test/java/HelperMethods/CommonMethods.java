package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    WebDriver driver;
   protected ElementMethods elementMethods;

    public CommonMethods(WebDriver driver)
    {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
    }
    public boolean isDisplayed (WebElement element){
    try {
        return element.isDisplayed();

    }catch (Exception e){
        return false;
    }
    }
    public void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,300)");
    } //in javaMethods class

    public void clickJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].click();", element);
    }

}
