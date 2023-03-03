package team8_testngproject.tests.us04;

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
    private final String testName = "US04 || TC01-Shipping address kaydetme POSITIVE senaryo";
    private final String description = "Doldurulmasi gereken zorunlu alanlar eksiksiz doldurulabilmeli";
    private final String raporMesaji = "Shipping adress kaydi tamamlandi";

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

        //     5. SIGN IN butonuna tiklanir.
        loginPage.signinsvd.click();
        loginPage.singoutsvd.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        //      6. My Account sayfasına erişildiğini dogrulanir.
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

        //    7. Addresses butonuna tiklanir.
        adressPage.addressvd.click();

        //    8. Shipping Adress bolumundeki ADD butonuna tiklanir.
        adressPage.shippingsvd.click();

        //    9. 10 .  First name inputuna veri girilir. //Last name inputuna veri girilir.
        Faker faker = new Faker();
        adressPage.shippingfirstnamesvd.clear();
        adressPage.shippingfirstnamesvd.sendKeys(faker.name().firstName());
        adressPage.shippinglastnamesvd.clear();
        adressPage.shippinglastnamesvd.sendKeys(faker.name().lastName());

        //    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(adressPage.shippingcountrysvd);
        select.selectByVisibleText("Turkey");

        //     12. Street adress alanina veri girilir.
        adressPage.shippingadressvd.clear();
        adressPage.shippingadressvd.sendKeys(faker.address().streetAddress());
        adressPage.shipping2adrsssvd.clear();
        adressPage.shipping2adrsssvd.sendKeys(faker.address().fullAddress());

        //     13.  Town/City alanina veri girilir.
        adressPage.shippingcity4svd.clear();
        adressPage.shippingcity4svd.sendKeys(faker.address().city());

        //    14.  Postcode / ZIP alanina veri girilir.
        adressPage.shippingpostcodesvd.clear();
        adressPage.shippingpostcodesvd.sendKeys(faker.address().zipCode());

        //    15. Province  dropdown'undan secim yapilir.
        Select select1 = new Select(adressPage.shippingdropdownsvd);
        select1.selectByVisibleText("Kayseri");

        //    16. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);
        RaporlamaUtil.extentTestInfo("Doldurulmasi gereken zorunlu alanlar eksiksiz dolduruldu.");

        // 17.   Kaydedilen adresin Shipping address olarak kayit edildigi dogrulanir.
        Assert.assertTrue(adressPage.shippingsavesvd.getText().contains("Address changed successfully."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}

