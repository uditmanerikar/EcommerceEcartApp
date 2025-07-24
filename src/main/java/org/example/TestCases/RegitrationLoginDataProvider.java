package org.example.TestCases;

import org.example.PageObjects.BaseClass;
import org.example.PageObjects.HomePage;
import org.example.PageObjects.Loginpage;
import org.example.Utilities.JsonReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class RegitrationLoginDataProvider  extends BaseClass {
    BaseClass baseClass = new BaseClass();
    @DataProvider(name="Logindata")
    public Object[][] Logindatacollection() throws IOException {

        return JsonReader.getjsondataashashmap("C:\\Users\\Ojas2\\IdeaProjects\\EcommerceApplicationAutomation\\src\\main\\resources\\Logindata.json");
    }

    @Test(dataProvider="Logindata")
    public void loginApp(String Browser,HashMap<String ,String> data) throws InterruptedException, IOException {
        baseClass.setup("chrome");
        Loginpage l = new Loginpage(driver);
        HomePage h = new HomePage(driver);
        l.login(data.get("username"), data.get("password"));

    }
}
