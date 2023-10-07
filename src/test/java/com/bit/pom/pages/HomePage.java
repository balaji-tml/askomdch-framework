package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "#menu-item-1227 > a") private WebElement storeMenuLink;
    @FindBy(css = "#menu-item-1237 > a") private WebElement accountMenuLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public HomePage load()
    {
        load("/");
        return this;
    }

    public StorePage navigateToStoreUsingMenu()
    {
        storeMenuLink.click();
        return new StorePage(driver);
    }
    public AccountPage navigateToAccountUsingMenu()
    {
        accountMenuLink.click();
        return new AccountPage(driver);
    }


}
