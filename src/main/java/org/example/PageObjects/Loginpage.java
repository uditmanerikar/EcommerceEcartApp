package org.example.PageObjects;

import org.example.TestBase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class Loginpage extends BasePage {
    public Loginpage(WebDriver driver){
        super(driver);
    }
    BaseClass b=new BaseClass();
   @FindBy(xpath  ="//a[@class='list-group-item'and text()='Login']")
   WebElement loginbutton;
    @FindBy(xpath="(//a[text()='Register'])[2]")
    WebElement RegistrationLink;
    @FindBy(xpath="(//input[@name='firstname'])")
    WebElement firstname;
    @FindBy(xpath="(//input[@name='lastname'])")
    WebElement lastname;
    @FindBy(xpath="(//input[@name='email'])")
    WebElement email;
    @FindBy(xpath="(//input[@name='telephone'])")
    WebElement telephone;
    @FindBy(xpath="(//input[@name='password'])")
    WebElement password;
    @FindBy(xpath="(//input[@name='confirm'])")
    WebElement confirmpassword;
    //
    @FindBy(xpath="(//a[@href='https://tutorialsninja.com/demo/index.php?route=information/information/agree&information_id=3']//following-sibling::input[@name='agree'])")
    WebElement agreeBtn;
    @FindBy(xpath="(//input[@value='Continue'])")
    WebElement ContinueButton;
    @FindBy(xpath ="//p[text()='Congratulations! Your new account has been successfully created!']")
    WebElement validatemessage;
    @FindBy (xpath="//input[@value='Login']")
    WebElement login;
    public void clickonRegistration(String fname,String lname,String em,String tele,String pwd){
        RegistrationLink.click();
        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        email.sendKeys(em);
        telephone.sendKeys(tele);
        password.sendKeys(pwd);
        confirmpassword.sendKeys(pwd);
        agreeBtn.click();
        ContinueButton.click();
    }
public String Validatemessage(){
        return validatemessage.getText();
}


public void login(String e,String p) throws InterruptedException {
    loginbutton.click();
    email.sendKeys(e);
    password.sendKeys(p);
    login.click();
    Thread.sleep(10000);
}
}