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

public class TC02 {
    private final String testName = "US04 || TC02-Shipping address kaydetme NEGATIVE senaryo";
    private final String description = "Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";
    private final String raporMesaji = "Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";

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
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        //      6. My Account sayfasına erişildiğini dogrulanir.
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

        //    7. Addresses butonuna tiklanir.
        adressPage.addressvd.click();

        //    8. Shipping Adress bolumundeki ADD butonuna tiklanir.
        adressPage.shippingsvd.click();

        //    9.    First name alani bos birakilir.
        Faker faker = new Faker();
        adressPage.shippingfirstnamesvd.clear();
        adressPage.shippingfirstnamesvd.sendKeys("");
        adressPage.shippinglastnamesvd.sendKeys(faker.name().lastName());
        Select select = new Select(adressPage.shippingcountrysvd);
        select.selectByVisibleText("Turkey");
        adressPage.shippingadressvd.clear();
        adressPage.shippingadressvd.sendKeys(faker.address().streetAddress());
        adressPage.shipping2adrsssvd.clear();
        adressPage.shipping2adrsssvd.sendKeys(faker.address().fullAddress());
        adressPage.shippingcity4svd.clear();
        adressPage.shippingcity4svd.sendKeys(faker.address().city());
        adressPage.shippingpostcodesvd.clear();
        adressPage.shippingpostcodesvd.sendKeys(faker.address().zipCode());
        Select select1 = new Select(adressPage.shippingdropdownsvd);
        select1.selectByVisibleText("Kayseri");

        //    10. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);
        RaporlamaUtil.extentTestInfo("Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli");

        //  11.Kaydin tamamlanamadigina dair "First name is a required field." hata mesaji goruntulendigi dogrulanir.
        Assert.assertFalse(adressPage.savesvd.getText().contains("First name is a required field."));
        // Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}




























