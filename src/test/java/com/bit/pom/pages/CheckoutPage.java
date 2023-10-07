package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import com.bit.pom.dataobject.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name") private WebElement firstNameFld;
    @FindBy(id = "billing_last_name") private WebElement lastNameFld;
    @FindBy(id = "billing_company") private WebElement companyNameFld;
    //@FindBy(id = "billing_country") private WebElement countryList;
    private final By countryList = By.id("billing_country");

    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_address_2") private WebElement billingAddressTwoFld;
    @FindBy(id = "billing_city") private WebElement cityFld;
    //@FindBy(id = "billing_state") private WebElement stateList;
    private final By stateList = By.id("billing_state");
    @FindBy(id = "billing_postcode") private WebElement postcodeFld;
    @FindBy(id = "billing_phone") private WebElement phoneFld;
    @FindBy(id = "billing_email") private WebElement emailFld;
    @FindBy(css = ".blockUI.blockOverlay") private WebElement overlay;
    @FindBy(id = "payment_method_bacs") private WebElement directBankTransfetFld;
    @FindBy(id = "payment_method_cod") private WebElement cashOnDeliveryFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = "#post-1221 > div > div > div > div > div > p") private WebElement orderConfirmationMsg;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CheckoutPage enterFirstName(String firstName)
    {
        firstNameFld.clear();
        firstNameFld.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName)
    {
        lastNameFld.clear();
        lastNameFld.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterCompanyName(String companyName)
    {
        companyNameFld.clear();
        companyNameFld.sendKeys(companyName);
        return this;
    }

    public CheckoutPage selectCountry(String country)
    {
        WebElement elm = waitForElementToBeVisible(countryList);
        Select countryList = new Select(elm);
        countryList.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String address_1)
    {
        billingAddressOneFld.clear();
        billingAddressOneFld.sendKeys(address_1);
        return this;
    }

    public CheckoutPage enterBillingAddressTwo(String address_2)
    {
        billingAddressTwoFld.clear();
        billingAddressTwoFld.sendKeys(address_2);
        return this;
    }

    public CheckoutPage enterCity(String city)
    {
        cityFld.clear();
        cityFld.sendKeys(city);
        return this;
    }

    public CheckoutPage selectState(String stateName)
    {
        WebElement elm = waitForElementToBeVisible(stateList);
        Select stateList = new Select(elm);
        stateList.selectByVisibleText(stateName);
        return this;
    }

    public CheckoutPage enterPostcode(String postcode)
    {
        postcodeFld.clear();
        postcodeFld.sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterPhone(String phone)
    {
        phoneFld.clear();
        phoneFld.sendKeys(phone);
        return this;
    }

    public CheckoutPage enterEmail(String email)
    {
        emailFld.clear();
        emailFld.sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress)
    {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterCompanyName(billingAddress.getCompanyName()).
                selectCountry(billingAddress.getCountry()).
                enterBillingAddressOne(billingAddress.getAddress_1()).
                enterBillingAddressOne(billingAddress.getAddress_2()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostcode(billingAddress.getPostcode()).
                enterPhone(billingAddress.getPhone()).
                enterEmail(billingAddress.getEmail());
    }

    public CheckoutPage selectDirectBankTransfer()
    {
        if(!directBankTransfetFld.isSelected())
        {
            directBankTransfetFld.click();
        }
        return this;
    }

    public CheckoutPage clickOnPlaceOrder()
    {
        //waitForOverlaysToDisappear(overlay);
        //WebElement elm = waitForElementToBeClickable(placeOrderBtn);
        placeOrderBtn.click();
        return this;
    }

    public String getOrderConfirmationMessage()
    {
       // WebElement elm = waitForElementToBeVisible(orderConfirmationMsg);
        return orderConfirmationMsg.getText();
    }



}
