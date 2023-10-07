package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(id = "username") private WebElement usernameFld;
    @FindBy(id = "password") private  WebElement passwordFld;
    @FindBy(xpath = "//button[contains(text(),'Log in')]") private WebElement loginBtn;

    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public AccountPage enterUsername(String username)
    {
        usernameFld.sendKeys(username);
        return this;
    }

    public AccountPage enterPassword(String password)
    {
        passwordFld.sendKeys(password);
        return this;
    }

    public AccountPage clickOnLogin()
    {
        loginBtn.click();
        return this;
    }

    public String getLoginConfirmationMsg(String user) throws InterruptedException {
        Thread.sleep(10000);
        By loginStatusMsg = By.xpath("//*[text()='"+user+"'][1]");
        WebElement elm = waitForElementToBeVisible(loginStatusMsg);
        String loginConfirmationMsg = elm.getText();
        return loginConfirmationMsg;
    }

}
