package team8_testngproject.tests.us12;

import org.openqa.selenium.Keys;
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

    private final String testName = "US12 || TC01-Billing Adress POSITIVE senaryo";
    private final String description = "Vendor Billing Address kaydı tamamlanmalı";
    private final String raporMesaji = "Vendor Billing Adress kaydi tamamlanmistir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01(){

        //     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //     2. Sing in butonuna tıklanir.
        P01_HomePage homePage = new P01_HomePage();
        homePage.signInButtonAli.click();

        //     3. Username ya da Email inputuna veri girilir.
        P03_LoginPage loginPage = new P03_LoginPage();
        loginPage.usernameAli.sendKeys(ConfigReader.getProperty("vendorUserNameAli"));

        //     4.  Password inputuna veri girilir.
        loginPage.passwordAli.sendKeys(ConfigReader.getProperty("vendorPasswordAli"));

        //      5. signOut butonuna tıklar
        loginPage.loginAli.click();
        RaporlamaUtil.extentTestInfo("Login islemi yapıldı");

        //      6. signOut butonuna tıklar
        homePage.signOutButtonAli.click();

        //      7. My Account sayfasına erişildiğini dogrulanir.
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        Assert.assertEquals(myAccountPage.myAccountPageAli.getText(), "My Account");
        RaporlamaUtil.extentTestInfo("MyAccount sayfasında oldugu dogrulandı.");

        //     8. Address butonuna tıklar.
        myAccountPage.AddressesLinkAli.click();

        //     9. Billilng (fatura) addressi add (edit your billing) butonuna tıklar
        P05_AddressesPage addressesPageAli = new P05_AddressesPage();
        ReusableMethods.jsClick(addressesPageAli.addButtonAli);

        //     10.  First name inputuna veri girilir. //Last name inputuna veri girilir.
        addressesPageAli.firstNameAli.clear();
        addressesPageAli.lastnameAli.clear();
        addressesPageAli.firstNameAli.sendKeys("Preto",
                Keys.TAB, "MEX");

        //    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(addressesPageAli.countryAli);
        select.selectByVisibleText("Mexico");

        //     12. Street adress alanina veri girilir.
        addressesPageAli.adreskutusuAli.clear();
        addressesPageAli.adress2Ali.clear();
        addressesPageAli.adreskutusuAli.sendKeys("060223");
        addressesPageAli.adress2Ali.sendKeys(" Elsalvador Street");

        //     13.  Town/City alanina veri girilir.
       addressesPageAli.city2Ali.sendKeys("Mexcio City");

        //     14.  State dropdown'undan secim yapilir.
        Select selectState = new Select(addressesPageAli.stateAli);
        select.selectByIndex(1);

        //    15.  Postcode / ZIP alanina veri girilir.
        addressesPageAli.kutu2Ali.clear();
        addressesPageAli.kutu2Ali.sendKeys("123456");

        //    16. Email adresinin otomatik olarak geldigi dogrulanir.
        Assert.assertTrue(addressesPageAli.emailAli.isDisplayed());

        //    17.Otomatik olarak gelen Email adresinin kayit olunan email adresiyle ayni oldugunu dogrulanir.
        Assert.assertEquals(ConfigReader.getProperty("vendorUserNameAli"), "salinger.samari@foundtoo.com");
        RaporlamaUtil.extentTestInfo("mail adresinin kayit olunan email adresiyle ayni oldugunu dogrulandı.");

        //     18. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(addressesPageAli.saveAdressButtonAli);

        //    19. Kaydedilen adresin Billing Address olarak kayit edildigi dogrulanir
        Assert.assertTrue(addressesPageAli.addreschangedsuccessfully.getText().contains("Address changed successfully."));
        RaporlamaUtil.extentTestInfo("degişiklik billing adrese eklendi.");

        Driver.closeDriver();

        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}
