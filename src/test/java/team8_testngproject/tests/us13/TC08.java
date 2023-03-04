package team8_testngproject.tests.us13;

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

public class TC08 {
    private final String testName = "US13 || TC08-Shipping Adress 'postcode_zıp' alanı  özel karakter kabul etmemeli";
    private final String description = "Vendor Shipping Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";
    private final String raporMesaji = "Vendor Shipping Address kaydi tamamlandı ve hata mesaji goruntulenmedi";


    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc8() {
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

        //     9. Shipping (sipariş) addressi add (edit your billing) butonuna tıklar
        P05_AddressesPage addressesPageAli = new P05_AddressesPage();
        ReusableMethods.jsClick(addressesPageAli.shippingaddButtonAli);

        //     10.  "firs name" alanına valid değer girer
        addressesPageAli.shippingfirstNameAli.clear();
        addressesPageAli.shippingfirstNameAli.sendKeys("Mex");


        //     11.  "last name" alanına valid deger girilir
        addressesPageAli.shippinglastNameAli.clear();
        addressesPageAli.shippinglastNameAli.sendKeys("Proteo");

        //     12.  "street address" alanına valid deger girilir
        addressesPageAli.shippingstreetAli.clear();
        addressesPageAli.shippingstreetAli.sendKeys("Ankara stree");

        //     13.  "postcode_zıp" özel karakter içermemeli/PASS

        addressesPageAli.shippingpostcodeAli.clear();
        addressesPageAli.shippingpostcodeAli.sendKeys("*/?0");
        ReusableMethods.jsClick(addressesPageAli.saveAdressButtonAli);
        RaporlamaUtil.extentTestInfo("postcode_zıp alanının özel karakter içermediği kontrol edilmiştir..");

        Assert.assertTrue(addressesPageAli.zipCoderequired.isDisplayed());
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        Driver.closeDriver();

    }

}

