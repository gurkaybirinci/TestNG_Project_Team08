package team8_testngproject.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC08_AcceptionalPassword_Medium {
    private final String testName = "US01 || TC08-Medium Password Mesaji ";
    private final String description = "Medium messajini alinca kayid islemi basarilidir";
    private final String raporMesaji = "Kullanıcı password alani altinda 'Medium' mesaji'ni gorur, ve kayid islami basarilidir";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void successfulRegistration_MediumPassward() {
        Driver.getDriver().get("https://hubcomfy.com/my-account-2/");
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        ReusableMethods.jsClick(homePage.myAccountButton);
        RaporlamaUtil.extentTestInfo("Home page sayfasindan My Account sayfasina gidilir");

        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        myAccountPage.myAccountSiginUpOnPopup.click();
        myAccountPage.myAccountUserNameReg.sendKeys(faker.name().username());
        myAccountPage.myAccountUserEmailReg.sendKeys(faker.internet().emailAddress());
        myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword4"));
        myAccountPage.myAccountPolicyCheckReg.click();
        RaporlamaUtil.extentTestInfo("Kullanici password alani altinda 'Medium' mesajini gormustur ve  kayid isleminde basarmistir");

        Assert.assertTrue(myAccountPage.notification_Medium.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}