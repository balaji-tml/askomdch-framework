package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserPage extends BasePage {

    @FindBy(id = "reg_username") private WebElement usernameFld;
    @FindBy(id = "reg_email") private WebElement emailFld;
    @FindBy(id = "reg_password") private WebElement passwordFld;
    @FindBy(css = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button") private WebElement registerBtn;

    public RegisterUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String username)
    {
//        driver.switchTo().frame(0);
        usernameFld.sendKeys(username);
    }

    public void setEmail(String email)
    {
        emailFld.sendKeys(email);
    }

    public void setPassword(String password)
    {
        passwordFld.sendKeys(password);
    }

    public AccountPage clickOnRegisterBtn()
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement elm = (WebElement) jse.executeScript("return document.querySelector(\"#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button\")");
        elm.click();
//        driver.findElement(registerBtn).click();
        return new AccountPage(driver);
    }
}
