package com.bit.pom.testcase;

import com.bit.pom.base.BaseTest;
import com.bit.pom.pages.AccountPage;
import com.bit.pom.pages.RegisterUserPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    //RegisterUserPage rup;

    @Test
    public void registerUserTest()
    {
        try {
            RegisterUserPage rup = new RegisterUserPage(driver);
            String username = "Better Tester3";
            String email = "BetterTester3@gmail.com";
            String password = "Password@123";
            //String confirmationMessage = driver.findElement((By.xpath("//*[@id='post-1235']/div/div[2]/div/div[2]/div/p[1]/strong[1]"))).getText();
            //if(confirmationMessage.contains(username)) {

//        String confirmationMsg="Hello "+username+" (not "+username+"? Log out)";
//        System.out.println("confirmationMsg: "+confirmationMsg);
//                "Hello "+username+" (not "+username+" Log out)";
            //driver.get("https://askomdch.com/account/");
            rup.load("/account");
            System.out.println("Page title is: " + driver.getTitle());
            rup.setUsername(username);
            rup.setEmail(email);
            rup.setPassword(password);
            AccountPage accountPage = rup.clickOnRegisterBtn();

            String pageSource = driver.getPageSource();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).isDisplayed());
//        }
//        else {
//            Assert.fail("Register User test is not successful");
//        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
