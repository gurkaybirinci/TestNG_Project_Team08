package team8_testngproject.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC02 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;

    @Test
    public void compareProductsUrunCikarma() {

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        homePage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        homePage.password.sendKeys(ConfigReader.getProperty("user_password"));
        homePage.login.click();
        ReusableMethods.waitFor(3);

        loginPage.search.click();
        loginPage.search.sendKeys("bag");
        loginPage.aramaTusu.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.sunnyBaby);
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
        ReusableMethods.waitFor(7);
        ReusableMethods.getScreenshot("Secili urun ekran goruntusu");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.silinenCanta);
        ReusableMethods.waitFor(5);
        ReusableMethods.getScreenshot("Silinen urun ekran goruntusu");
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        loginPage.search.click();
        String arananUrun = "coat";
        loginPage.search.sendKeys(arananUrun);
        loginPage.aramaTusu.click();
        String coatDogrulama = "Coat Pool Comfort Jacket";
        Assert.assertFalse(coatDogrulama.contains(arananUrun));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.coatUrunEkle);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Coat urunu ekleme");

    }
}
