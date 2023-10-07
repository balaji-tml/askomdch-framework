package com.bit.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Wait<WebDriver> fwait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

    }

    public void load(String endPoint)
    {
        String baseURl = "https://askomdch.com/";
        driver.get(baseURl + endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay)
    {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY size: "+overlays.size());
        if(overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAY INVISIBLE");
        }
        else
        {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public WebElement waitForElementToBeVisible(By element)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}