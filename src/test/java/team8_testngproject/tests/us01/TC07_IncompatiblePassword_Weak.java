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

public class TC07_IncompatiblePassword_Weak {
    private final String testName = "US01 || TC07-Weak Password Mesaji ";
    private final String description = "Weak mesaji alinca kayid islemi basarisizdir";
    private final String raporMesaji = "kullanici password alani altinda 'Weak - Please enter a stronger password' uyarisini gormeli";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void UnsuccessfulRegistration_weakPassword() {
        Driver.getDriver().get("https://hubcomfy.com/my-account-2/");
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        ReusableMethods.jsClick(homePage.myAccountButton);
        RaporlamaUtil.extentTestInfo("Home page sayfasindan My Account sayfasina gidilir");

        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        myAccountPage.myAccountSiginUpOnPopup.click();
        myAccountPage.myAccountUserNameReg.sendKeys(faker.name().username());
        myAccountPage.myAccountUserEmailReg.sendKeys(faker.internet().emailAddress());
        myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword3"));
        RaporlamaUtil.extentTestInfo("kullanici password alani altinda 'Weak - Please enter a stronger password' uyarisini gorur");

        Assert.assertTrue(myAccountPage.notification_Weak.isDisplayed());

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
