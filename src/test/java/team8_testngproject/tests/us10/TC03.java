package team8_testngproject.tests.us10;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC03 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US10 || TC03-Password Metin Kutusu";
    private final String description = "Password Metin Kutusuna veri girildiğinde uyarı mesajı almalı";
    private final String raporMesaji = "Password Metin Kutusuna metin girildiğinde -good- yazısının görünürlüğü doğrulandı";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void us10_Tc03() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı registor butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı kayıtlı olduğu mail adresini girer
        vendorRegisterPage = new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));
        RaporlamaUtil.extentTestInfo("Kullanıcı mail adresini girebildi.");

        //Kullanıcı  password kısmına 6 karakterli, küçük harf, rakam,özel karakter içeren bir şifre girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_good_psw"));
        RaporlamaUtil.extentTestInfo("Kullanıcı girdiği şifrenin derecesinin Good olduğunu belirten yazının görünürlüğü kontrol edildi");

        Assert.assertEquals(vendorRegisterPage.pswCommentZb.getText(), "Good");
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}
