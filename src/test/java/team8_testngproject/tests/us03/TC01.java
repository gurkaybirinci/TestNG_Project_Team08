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

public class TC01 {
    private final String testName = "US03 || TC01-Billing Adress POSITIVE senaryo";
    private final String description = "Billing Address kaydı tamamlanmalı";
    private final String raporMesaji = "Billing Adress kaydi tamamlanmistir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testTC01() {
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

        //     5. SIGN IN  butonuna tiklanir.
        loginPage.signinsvd.click();
        loginPage.singoutsvd.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        //      6. My Account sayfasına erişildiğini dogrulanir.
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

        //    7.   Addresses butonuna tiklanir.
        adressPage.addressvd.click();

        //    8.  Billing Adress bolumundeki ADD butonuna tiklanir.
        adressPage.addsvd.click();

        //    9.  First name inputuna veri girilir. //Last name inputuna veri girilir.

        Faker faker = new Faker();
        adressPage.firstNamesvd.clear();
        adressPage.firstNamesvd.sendKeys(faker.name().firstName());

        //  10. Last name inputuna veri girilir.
        adressPage.lastNamesvd.clear();
        adressPage.lastNamesvd.sendKeys(faker.name().lastName());

        //    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(adressPage.countrysvd);
        select.selectByVisibleText("Turkey");

        //     12. Street adress alanina veri girilir.
        adressPage.adreskutususvd.clear();
        adressPage.adreskutususvd.sendKeys(faker.address().streetAddress());
        adressPage.adress2svd.clear();
        adressPage.adress2svd.sendKeys(faker.address().fullAddress());

        //     13.  Town/City alanina veri girilir.
        adressPage.city2svd.clear();
        adressPage.city2svd.sendKeys(faker.address().city());

        //    14.  Postcode / ZIP alanina veri girilir.
        adressPage.kutu2svd.clear();
        adressPage.kutu2svd.sendKeys(faker.address().zipCode());

        //    15.  Province dropdown'undan secim yapilir.
        Select select1 = new Select(adressPage.statessvd);
        select1.selectByVisibleText("Kayseri");

        //    16. Phone alanina veri girilir.
        adressPage.phonesvd.clear();
        adressPage.phonesvd.sendKeys(faker.phoneNumber().cellPhone());

        //     17. Email adresinin otomatik olarak geldigi dogrulanir.
        Assert.assertTrue(adressPage.emailsvd.isDisplayed());

        //    18. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);
        RaporlamaUtil.extentTestInfo("Billing Adress kaydi tamamlandi.");

        //    19. Kaydedilen adresin Billing Address olarak kayit edildigi dogrulanir
        Assert.assertTrue(adressPage.saveadresssvd.getText().contains("Address changed successfully."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}
