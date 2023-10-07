package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//td/a[contains(text(),'Blue Shoes')]") private WebElement productName;
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]") private WebElement checkOutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getProductName()
    {
        return productName.getText();
    }

    public CheckoutPage checkout()
    {
        checkOutBtn.click();
        return new CheckoutPage(driver);
    }
}
