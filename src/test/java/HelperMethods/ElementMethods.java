package HelperMethods;


import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;

import java.io.File;


public class ElementMethods {
    WebDriver driver;

    public ElementMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void clearFillElement(WebElement element, String text) {
        Assert.assertTrue(element.isDisplayed());
        element.clear();
        LoggerUtility.infoTest("Element was cleared");// Delete initial content
        element.sendKeys(text);
        LoggerUtility.infoTest("The field was completed");// Fill field
        String newValue = element.getAttribute("value");
        Assert.assertFalse(newValue.isEmpty());
        Assert.assertEquals(newValue, text);
    }
    public void fillElement(WebElement element, String text) {
        Assert.assertTrue(element.isDisplayed());
        element.sendKeys(text);
        LoggerUtility.infoTest("The field was completed");
        String newValue = element.getAttribute("value");
        Assert.assertFalse(newValue.isEmpty());
        Assert.assertEquals(newValue, text);
    }


    public void textModificationAssert(WebElement element, String text)
    {
        if (element.getText().equals(text))
        {
            Assert.assertTrue(element.isDisplayed());
        }

        if (element.getText().contains(text))
        {
            Assert.assertTrue(element.isDisplayed());
        }

        else if (element.getText().isEmpty())
        {
            System.out.println("Kokoko" + " is not visible");
        }
    }

    public void addFile(WebElement element,String image){
        File file = new File(image);
        String absolutePath = file.getAbsolutePath();
        element.sendKeys(absolutePath);
    }


    public void assertCurrentUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }






}
