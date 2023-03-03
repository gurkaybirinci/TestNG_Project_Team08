package team8_testngproject.tests.us11;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC01 {
    private final String testName = "US11 || TC01 Kullanıcı Vendor giriş yapmalı.";
    private final String description = "Vendor olarak email ve şifre girilmeli ve sistemde My Account görünmeli";
    private final String raporMesaji = "Açılan sayfanın başlığının My Account olduğu görülmeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void test01() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("vendorUserNameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("vendorPasswordEs"));
        p03_loginPage.signInButon_Es.click();
        RaporlamaUtil.extentTestInfo("Login işlemi vendor olarak yapıldı.");
        p01_homePage.signOut_Es.click();

        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        RaporlamaUtil.extentTestInfo("My Account sayfasında olduğu doğrulandı.");
        Assert.assertEquals(p04_myAccountPage.myAccountSayfasi_Es.getText(), "My Account");

        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
