package team8_testngproject.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P06_AccountDetailes;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC01_Kullanici_Hesap_Detaylarini_Gorme {
    private final String testName = "US05 || TC01 Kullanıcı hesap detaylarını görme";
    private final String description = "Kullanıcı hesap detaylarını (Account Details) görebilmeli";
    private final String raporMesaji = "Kullanıcının hesap detaylarını görüdüğü doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void tc01() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        p01_homePage.signOut_Es.click();

        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();
        RaporlamaUtil.extentTestInfo("Account Details sayfasına gidildi");

        P06_AccountDetailes p06_accountDetailes = new P06_AccountDetailes();
        Assert.assertEquals(p06_accountDetailes.accountDetailsSayfasindamisin_Es.getText(), "Account Details");

        RaporlamaUtil.extentTestInfo("Kullanıcı hesap detaylarını (Account Details) görüldü.");
        Assert.assertTrue(p06_accountDetailes.firstName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.lastName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.displayName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.emailAdress_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.biography_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.passwordAlani1_Es.isDisplayed());
        Driver.closeDriver();

        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
