package team8_testngproject.tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P05_AddressesPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC02 {
    private final String testName = "US03 || TC02-Billing Address kaydetme NEGATIVE senaryo";
    private final String description = "Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";
    private final String raporMesaji = "Address kaydi tamamlanamadi ve hata mesaji goruntulendi";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void testTC02() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P05_AddressesPage adressPage = new P05_AddressesPage();

        //     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //    2.  Sing in butonuna tıklanir.
        homePage.signInButtonsvd.click();

        //     3. Username ya da Email inputuna veri girilir.
        loginPage.usernamesvd.sendKeys(ConfigReader.getProperty("user_namesvd"));

        //     4.  Password inputuna veri girilir.
        loginPage.passwordsvd.sendKeys(ConfigReader.getProperty("user_passwordsvd"));

        //     5. SIGN IN butonuna tiklanir.
        loginPage.signinsvd.click();
        loginPage.singoutsvd.click();
        //   RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        //      6. My Account sayfasına erişildiğini dogrulanir.
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

        //    7.   Addresses butonuna tiklanir.
        adressPage.addressvd.click();

        //    8.  Billing Adress bolumundeki ADD butonuna tiklanir.
        adressPage.addsvd.click();

        //    9.  First name inputuna veri girilir. //Last name inputuna veri girilir.

        Faker faker = new Faker();
        adressPage.firstNamesvd.clear();
        adressPage.firstNamesvd.sendKeys("");
        adressPage.lastNamesvd.clear();
        adressPage.lastNamesvd.sendKeys(faker.name().lastName());
        Select select = new Select(adressPage.countrysvd);
        select.selectByVisibleText("Turkey");
        adressPage.adreskutususvd.clear();
        adressPage.adreskutususvd.sendKeys(faker.address().streetAddress());
        adressPage.adress2svd.clear();
        adressPage.adress2svd.sendKeys(faker.address().fullAddress());
        adressPage.city2svd.clear();
        adressPage.city2svd.sendKeys(faker.address().city());
        adressPage.kutu2svd.clear();
        adressPage.kutu2svd.sendKeys(faker.address().zipCode());
        Select select1 = new Select(adressPage.statessvd);
        select1.selectByVisibleText("Kayseri");
        adressPage.phonesvd.clear();
        adressPage.phonesvd.sendKeys(faker.phoneNumber().cellPhone());

        //   10. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);
        RaporlamaUtil.extentTestInfo("Address kaydi tamamlanamadi ve hata mesaji goruntulendi.");

        //    11.  Kaydin tamamlanamadigina dair "Province is a required field." hata mesaji goruntulendigi dogrulanir.
        Assert.assertTrue(adressPage.msjsvd.getText().contains("First name is a required field."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }

}
