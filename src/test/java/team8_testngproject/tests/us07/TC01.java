package team8_testngproject.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC01 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    private final String testName = "US07 || TC01-Karsilastirma icin urun secimi";
    private final String description = "Karsilastirma icin urunler secilebilmeli";
    private final String raporMesaji = "Karsilastirma icin urunler secilmistir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
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
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        loginPage.search.click();
        loginPage.search.sendKeys("bag");
        loginPage.aramaTusu.click();
        RaporlamaUtil.extentTestInfo("Urun karsilastirma icin sayfaya gidildi.");

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
        ReusableMethods.waitFor(3);
        RaporlamaUtil.extentTestInfo("Urunler secildi.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        Driver.closeDriver();
    }
}
