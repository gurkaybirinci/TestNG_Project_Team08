package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC01_Become_a_Vendor_Giris {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US09 || TC01- Become a Vendor Giriş";
    private final String description = "Vendor (Satıcı) olarak, siteye kayıt yapılabilmeli." + "(Vendor Registration)";
    private final String raporMesaji = "Kullanıcının Become a Vendor sayfasına giriş yapabildiği doğrulanmışır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc01() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Vendor Registration sayfasının erişildiğini dogrular
        vendorRegisterPage = new P14_VendorRegisterPage();
        RaporlamaUtil.extentTestInfo("Kullanıcının giriş yapabilirliği kontrol edildi");

        Assert.assertEquals(vendorRegisterPage.vendorDogrulaZb.getText(), "Vendor Registration");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}


        







