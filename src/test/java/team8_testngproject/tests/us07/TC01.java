package team8_testngproject.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class  TC01 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;

    @Test
    public void urunSecimi() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        loginPage.password.sendKeys(ConfigReader.getProperty("user_password"));
        loginPage.login.click();
        ReusableMethods.waitFor(3);

        loginPage.search.click();
        loginPage.search.sendKeys("bag");
        loginPage.aramaTusu.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaTheMono);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaWomen);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaBest);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaFash);
        ReusableMethods.waitFor(3);
    }
}
