package com.bit.pom.pages;

import com.bit.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    @FindBy(id = "woocommerce-product-search-field-0") private WebElement searchFld;
    @FindBy(xpath = "//button[contains(text(),'Search')]") private WebElement searchBtn;

    @FindBy(css = ".woocommerce-products-header__title.page-title") private WebElement title;
    @FindBy(css = "a[arial-label='Add “Blue Shoes” to your cart']") private WebElement addToCartBtn;
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;

    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public StorePage enterTextInSearchFld(String searchText)
    {
        searchFld.sendKeys(searchText);
        return this;
    }

    public StorePage clickOnSearchBtn()
    {
        searchBtn.click();
        return this;
    }

    public StorePage search(String searchText)
    {
        searchFld.sendKeys(searchText);
        searchBtn.click();
        return this;
    }



    private By getAddToCartBtnElement(String productName)
    {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public StorePage clickOnAddToCartBtn(String productName)
    {
        By addToCartBtn = getAddToCartBtnElement(productName);
        WebElement elm = waitForElementToBeClickable(addToCartBtn);
        elm.click();
        return this;
    }

    public CartPage navigateToViewCart()
    {
        viewCartLink.click();
        return new CartPage(driver);
    }


}
