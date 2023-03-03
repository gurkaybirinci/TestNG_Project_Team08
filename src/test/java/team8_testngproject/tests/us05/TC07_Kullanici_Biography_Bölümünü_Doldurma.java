package team8_testngproject.tests.us05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P06_AccountDetailes;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC07_Kullanici_Biography_Bölümünü_Doldurma {
    private final String testName = "US05 || TC07 Kullanıcı Biography bölümünü doldurma ";
    private final String description = "Kullanıcı Biography bölümünü doldurabilmeli";
    private final String raporMesaji = "Kullanıcının kayıt yaptığı görülmüştür.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void test07() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        Faker faker = new Faker();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");
        p01_homePage.signOut_Es.click();

        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();
        RaporlamaUtil.extentTestInfo("Account Details e gidildi.");

        P06_AccountDetailes p06_accountDetailes = new P06_AccountDetailes();
        Assert.assertEquals(p06_accountDetailes.accountDetailsSayfasindamisin_Es.getText(), "Account Details");
        ReusableMethods.waitFor(5);
        Driver.getDriver().switchTo().frame(p06_accountDetailes.biography_Es);
        p06_accountDetailes.bodyID_Es.clear();
        p06_accountDetailes.bodyID_Es.sendKeys("Bu bir deneme yazısıdır. Biography yazısı değil.",
                Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);

        RaporlamaUtil.extentTestInfo("Biography bölümüne yazının yazıldığı ve SAVE işleminin yapıldığı görüldü");

        Assert.assertEquals(p06_accountDetailes.saveSuccessYazisi_Es.getText(), "Account details changed successfully.");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
