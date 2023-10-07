package com.bit.pom.testcase;

import com.bit.pom.base.BaseTest;
import com.bit.pom.dataobject.BillingAddress;
import com.bit.pom.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTestcase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() {
        try {
            BillingAddress billingAddress = new BillingAddress("demo", "user", "My Infotech Company", "India", "123,BTM", "Near My Landmark", "Bangalore", "Karnataka", "560039", "9878767656", "MyName@email.com");
            String searchText = "Blue";
            String actualMsg = "";
            String expectedMsg = "Search results: “" + searchText + "”";

            HomePage homePage = new HomePage(driver);
            homePage.load();
            StorePage storePage = homePage.navigateToStoreUsingMenu();
            storePage.search(searchText);

            actualMsg = driver.findElement(By.cssSelector("#main > div > header > h1")).getText();
            Assert.assertEquals(actualMsg, expectedMsg);

            storePage.clickOnAddToCartBtn("Blue Shoes");

            CartPage cartPage = storePage.navigateToViewCart();

            CheckoutPage checkoutPage = cartPage.checkout();
            checkoutPage
                    .setBillingAddress(billingAddress)
                    .selectDirectBankTransfer()
                    .clickOnPlaceOrder();
            String actOrderConfirmationMessage = checkoutPage.getOrderConfirmationMessage();
            String expOrderConfirmationMessage = "Thank you. Your order has been received.";
            Assert.assertEquals(actOrderConfirmationMessage, expOrderConfirmationMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() {
        try {

            BillingAddress billingAddress = new BillingAddress("demo", "user", "My Infotech Company", "India", "123,BTM", "Near My Landmark", "Bangalore", "Karnataka", "560039", "9878767656", "MyName@email.com");

            String user = "Better Tester2";
            String username = "bettertester2@gmail.com";
            String password = "Password@123";
            String searchText = "Blue";
            String actualMsg = "";
            String expectedMsg = "Search results: “" + searchText + "”";
            HomePage homePage = new HomePage(driver);
            homePage.load();
            AccountPage accountPage = homePage.navigateToAccountUsingMenu();
            accountPage.enterUsername(username);
            accountPage.enterPassword(password);
            accountPage.clickOnLogin();

            if (user.equals(accountPage.getLoginConfirmationMsg(user))) {

                StorePage storePage = homePage.navigateToStoreUsingMenu();
                storePage.search(searchText);

                actualMsg = driver.findElement(By.cssSelector("#main > div > header > h1")).getText();
                Assert.assertEquals(actualMsg, expectedMsg);

                storePage.clickOnAddToCartBtn("Blue Shoes");

                CartPage cartPage = storePage.navigateToViewCart();

                CheckoutPage checkoutPage = cartPage.checkout();
                checkoutPage
                        .setBillingAddress(billingAddress)
                        .selectDirectBankTransfer()
                        .clickOnPlaceOrder();
                String actOrderConfirmationMessage = checkoutPage.getOrderConfirmationMessage();
                String expOrderConfirmationMessage = "Thank you. Your order has been received.";
                Assert.assertEquals(actOrderConfirmationMessage, expOrderConfirmationMessage);
            } else {
                System.out.println("Login and Checkout using DirectBankTransfer is not Successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
