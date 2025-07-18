package org.example.PageObjects;

import org.openqa.selenium.WebDriver;
import org.example.TestBase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }
@FindBy (xpath="//ul[@class='nav navbar-nav']/li")
List<WebElement> AllButtons;

public void getitems(String TypeOfItem) throws InterruptedException {
   for(WebElement li:AllButtons){
       if(li.getText().equals(TypeOfItem)){
           li.click();
           Thread.sleep(7000);
       }
   }
}
}
