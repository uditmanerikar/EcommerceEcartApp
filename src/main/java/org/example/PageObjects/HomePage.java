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

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Cameras']")
    private WebElement button;

    // This method clicks the specified item (like "Cameras", "Phones", etc.)
    public void getitems(String typeOfItem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Re-fetching fresh elements to avoid stale element exception
        List<WebElement> allButtons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='nav navbar-nav']/li"))
        );

        for (WebElement li : allButtons) {
            if (li.getText().trim().equalsIgnoreCase(typeOfItem.trim())) {
                li.click();
                break;
            }
        }
    }

    // This method checks visibility of the <h2> element (e.g., after clicking "Cameras")
    public boolean isVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        System.out.println("pass");
        return button.isDisplayed();
    }
}
