package org.example.PageObjects;
import org.example.TestBase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Product_Page extends BasePage {
    public Product_Page (WebDriver driver) {
        super(driver);
    }
    private static final String itemxpath = "//h1[normalize-space()='%s']";
    @FindBy (xpath = "//input[@id=\"input-quantity\"]")
    WebElement Qty;
    @FindBy (xpath = "//button[@id=\"button-cart\"]")
    WebElement AddToCart;
    @FindBy (xpath = "//ul[@class='list-unstyled']/li/h2")
    WebElement qtyvalue;
    @FindBy (xpath = "//span[@id=\"cart-total\"]")
    WebElement getcarttext;
    public void seelctitem(String nameOfItem){
        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> items=w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"product-thumb\"]//h4//a")));
        for(WebElement selectitem:items) {
            if (
            selectitem.getText().trim().equals(nameOfItem))
            {
                selectitem.click();
                System.out.println(selectitem);
                System.out.println("Item selected");
            }
        }
    }
    public void HaveYouSelectedItem(String productname){
        String dynamicxpath=String.format(itemxpath ,productname);
        WebElement e=driver.findElement(By.xpath(dynamicxpath));
    e.isDisplayed();
}
    public double gettextqty() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(qtyvalue));
        String s=qtyvalue.getText();
        return Double.parseDouble(s.replace("$","").trim());
    }
    public  void addqty(int qty){
    Qty.click();
    Qty.clear();
    Qty.sendKeys(String.valueOf(qty));
}

public void addtocart(){
    AddToCart.click();
}

public String getcarttext(){
    String s=getcarttext.getText();
    String amount = s.replaceAll(".*\\$(\\d+).*", "$1");
return  amount;
}

}