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

public class TC03_E_mail_kutusu {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US09 || TC03-Email kutusu";
    private final String description = "e-mail adresine invalid değer girmeli";
    private final String raporMesaji = "Kullanıcı invalid mail girdiğinde hata mesajı aldığı doğrulanmıştır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc03() {
        //Kullanıcı fake Url gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));
        vendorRegisterPage = new P14_VendorRegisterPage();
        String fakeMail = vendorRegisterPage.fakeMailKutuZb.getText();
        String yeniMail = fakeMail.replace(".com", " ");

        //Kullanıcı URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı fake email'i eksik girer
        vendorRegisterPage = new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(yeniMail);
        RaporlamaUtil.extentTestInfo("Kullanıcı email kutusuna  invalid değer girdiği doğrulanmışır");

        //Kullanıcı verificationCode kutusuna tıklar (Please provide a valid email address.)
        vendorRegisterPage.verificationCodeClick.click();
        ReusableMethods.waitFor(3);
        System.out.println(vendorRegisterPage.eksikMailHataMesajiZb.getText());
        RaporlamaUtil.extentTestInfo("Kullanıcı email kutusuna invalid değer girdiğinde hata mesajı alma durumu kontrol edildi");

        Assert.assertTrue(vendorRegisterPage.eksikMailHataMesajiZb.getText().contains("Please provide a valid email address."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
