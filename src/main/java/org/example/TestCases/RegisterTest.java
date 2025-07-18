package org.example.TestCases;

import org.example.PageObjects.BaseClass;
import org.example.PageObjects.HomePage;
import org.example.PageObjects.Loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class RegisterTest extends BaseClass {
    BaseClass baseClass = new BaseClass();
    @Test(priority = 1)
    @Parameters("Browser")
    public void Register(String Browser) throws IOException {
        Properties p;
       // BaseClass baseClass = new BaseClass();
        baseClass.setup(Browser);
        Loginpage l=new Loginpage(driver);
        l.clickonRegistration(baseClass.getproperty("fname"),baseClass.getproperty("lname"),baseClass.Randomstring()+"@gmail.com", baseClass.RandomNumber(), baseClass.getproperty("password"));
       // l.clickonRegistration(baseClass.Randomstring(),baseClass.Randomstring(),baseClass.Randomstring()+"@gmail.com", baseClass.RandomNumber());
        String ActualMessage=l.Validatemessage();
        Assert.assertEquals(ActualMessage,"Congratulations! Your new account has been successfully created!");

    }
    @Test(priority = 2)
    @Parameters("Browser")
    public void LoginTest(String Browser) throws IOException, InterruptedException {
        //BaseClass baseClass = new BaseClass();
        baseClass.setup(Browser);
        Loginpage l=new Loginpage(driver);
        HomePage h=new HomePage(driver);
        l.login(baseClass.getproperty("email"), baseClass.getproperty("password"));
        h.getitems("Cameras");

    }

    @AfterMethod
    public void killbrowser(){
        // baseClass.TearDown();
    }
}
