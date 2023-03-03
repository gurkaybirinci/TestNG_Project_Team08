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

public class TC04_Verification_Code_text_kutusu {

    private final String testName = "US09 || TC04-Verification Code text kutusu";
    private final String description = "Verification Code text kutusuna geldiğinde uyarı mesajı görmeli ";
    private final String raporMesaji = "Verification Code text  kutusuna geldiğinde uyarı mesajı gördüğü doğrulanmıştır ";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc04() {

        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage = new P14_VendorRegisterPage();
        String fakeMail = vendorRegisterPage.fakeMailKutuZb.getText();
        RaporlamaUtil.extentTestInfo("Kullanıcının fake mail adresi alabilirliği kontrol edildi");

        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı valid Email bilgileri girer
        vendorRegisterPage.emailzb.sendKeys(fakeMail);
        RaporlamaUtil.extentTestInfo("Kullanıcı email kutusuna  valid değer girdiği doğrulanmışır");

        //Verification Code text kutsuna tıklar
        vendorRegisterPage.verificationCodeClick.click();

        //Verification Code text kutsuna tıklar( "Verification code sent to your email: abc@abc.com." mesajını görmeli)
        ReusableMethods.waitFor(3);
        String dogrulama = vendorRegisterPage.codeSuccess.getText();

        System.out.println("Doğrulama:" + dogrulama);
        RaporlamaUtil.extentTestInfo("Kullanıcı mail adresini girdiğinde, mail adresine gönderilen Verification code olduğu mesajının görünürlüğünü kontrol eder");

        Assert.assertTrue(vendorRegisterPage.codeSuccess.getText().contains(dogrulama));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
