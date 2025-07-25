package org.example.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    Properties p;
    public void setup(String Br) throws IOException {
        FileReader f=new FileReader("src/main/resources/Config.properties");
        p=new Properties();
        p.load(f);
        if (Br == null || Br.isEmpty()) {
            throw new IllegalArgumentException("Browser type cannot be null or empty.");
        }
        switch (Br.toLowerCase()){
//            case "chrome" :
//               // driver =new ChromeDriver();
//                WebDriverManager.chromedriver().setup();
//               ChromeOptions options = new ChromeOptions();
//                options.addArguments("--guest", "--remote-allow-origins=*");
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ojas2\\IdeaProjects\\EcommerceApplicationAutomation\\Driverlocation\\chromedriver.exe");
//                WebDriver driver = new ChromeDriver(options);
//                break;
            case "chrome":
                WebDriverManager.chromedriver().setup(); // automatically handles version & path

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--guest", "--remote-allow-origins=*");

                driver = new ChromeDriver(options); // ✅ assigning to class-level driver
                break;

            case "firefox" :
                WebDriverManager.edgedriver().setup();
                FirefoxOptions e = new FirefoxOptions();
                e.addArguments("--guest", "--remote-allow-origins=*");
                driver =new FirefoxDriver(e);
                break;
            case "edge" :
               WebDriverManager.edgedriver().setup();
               WebDriverManager.edgedriver().avoidBrowserDetection().cachePath("drivers").setup();
               EdgeOptions e1 = new EdgeOptions();
               e1.addArguments("--guest", "--remote-allow-origins=*");
               driver =new EdgeDriver(e1);
               break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + Br);


    }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("URL"));

    }
    public void TearDown(){
        driver.quit();
    }
    public String  Randomstring(){
        String Randowmstr= RandomStringUtils.randomAlphabetic(5);
        return Randowmstr;

    }
    public String  RandomNumber(){
        String randomNumber= RandomStringUtils.randomNumeric(5);
        return randomNumber;

    }
    public String getproperty(String key){
     return p.getProperty(key);

    }

    public static String takesscreenshot(String Testname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//Screenshots//" + Testname + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//Screenshots//" + Testname + ".png";
    }
}
