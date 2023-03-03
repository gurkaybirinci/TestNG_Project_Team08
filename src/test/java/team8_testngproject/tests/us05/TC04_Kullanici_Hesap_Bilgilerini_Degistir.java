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

public class TC04_Kullanici_Hesap_Bilgilerini_Degistir {
    private final String testName = "US05 || TC04 Kullanıcı hesap bilgilerini değiştir ";
    private final String description = "Kullanıcı last name alanı boş iken kayıt yapamamalı";
    private final String raporMesaji = "Kullanıcının kayıt yapamadığı görülmüştür.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void test04() {
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

        p06_accountDetailes.firstName_Es.clear();
        p06_accountDetailes.firstName_Es.sendKeys(faker.name().firstName());
        p06_accountDetailes.lastName_Es.clear();
        p06_accountDetailes.displayName_Es.clear();
        p06_accountDetailes.displayName_Es.sendKeys(faker.name().username());
        p06_accountDetailes.emailAdress_Es.clear();

        p06_accountDetailes.emailAdress_Es.sendKeys(faker.internet().emailAddress(),
                Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB, Keys.ENTER);
        RaporlamaUtil.extentTestInfo("Last name hariç , first name, display name, e mail verileri girildi ve SAVE işleminin gerçekleşmediği görüldü.");

        Assert.assertTrue(p06_accountDetailes.saveFailLastName_Es.isDisplayed());
        Driver.closeDriver();

        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
