package testsuite.testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility
{
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup()
    {
        openBrowser(baseURL);

    }

    @Test
    public void userSholdLoginSuccessfullyWithValid()
    {
        //Enter username
        sendTextElement(By.id("user-name"),"standard_user");

       //Enter password
        sendTextElement(By.name("password"),"secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify the text “PRODUCTS”
        String expectedMessage ="Products";
       String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));

        //checking actual and expected result
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Enter username
        sendTextElement(By.id("user-name"),"standard_user");


        //Enter password
        sendTextElement(By.name("password"),"secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));



        //Verify that Six products are displayed on page
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumber = number.size();
        int expectedNumber = 6;


        //checking actual and expected result
        Assert.assertEquals("6 product not displayed", expectedNumber, actualNumber);
        System.out.println("No of Product : " + actualNumber);

    }

    @After
    public void teardown()
    {
        closeBrowser();
    }

}
