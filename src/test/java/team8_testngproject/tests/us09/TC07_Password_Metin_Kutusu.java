package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC07_Password_Metin_Kutusu {
    private final String testName = "US09 || TC07-Password Metin Kutusu";
    private final String description = "Password kutusuna veri girilebilmeli";
    private final String raporMesaji = "Password metin kutusuna veri girilebildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc07() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı Email bilgileri girer
        P14_VendorRegisterPage vendorRegisterPage = new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));

        //Verification Code girer
        vendorRegisterPage.verificationCodeClick.sendKeys(ConfigReader.getProperty("vendor_code"));

        //Kullanıcı Password kutusuna kucuk harf, büyük harf, rakam ve special karakter girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));

        //Kullanıcı Confirm Password alanına, Password kutusuna girmiş olduğu bilgileri girer
        vendorRegisterPage.confirmPwd.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));

        //Kullanıcı Register butonuna tıklar (Kullanıcı "Password strength should be atleast "Good". mesajını görmeli)
        vendorRegisterPage.vendorRegisterClickZb.click();
        ReusableMethods.waitFor(5);
        vendorRegisterPage.vendorRegisterClickZb.click();
        RaporlamaUtil.extentTestInfo("Kullanıcının Password kısmına veri girdiğinde uyarı mesajı gördüğü doğrulanmışır");

        Assert.assertEquals(vendorRegisterPage.kisaPwdMesaj.getText(), "Password strength should be atleast \"Good\".");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
