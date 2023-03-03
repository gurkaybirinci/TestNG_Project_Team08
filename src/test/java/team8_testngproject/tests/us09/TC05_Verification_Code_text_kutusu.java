package team8_testngproject.tests.us09;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC05_Verification_Code_text_kutusu {

    private final String testName = "US09 || TC05-Verification Code text kutusu";
    private final String description = "Mail adresine gelen kodu Verification Code text kutusuna girmeli";
    private final String raporMesaji = "Mail adresine gelen Verification Code, code text kutusuna girildiği doğrulanmıştır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc05() {
        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage = new P14_VendorRegisterPage();
        String fakeMail = vendorRegisterPage.fakeMailKutuZb.getText();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()"); //Yeni sekme açar

        //Kullanıcı Url gider
        ReusableMethods.switchToWindow(1); // Yeni sekmeye geçer
        Driver.getDriver().navigate().to("https://hubcomfy.com/vendor-register/"); // Yeni sekmede URL'yi açar

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı fake Url den aldığı  Email bilgileri girer
        vendorRegisterPage.emailzb.sendKeys(fakeMail);

        //Verification Code text kutusuna tıklar
        vendorRegisterPage.verificationCodeClick.click();
        ReusableMethods.waitFor(5);

        //Kullanıcı Fake Email kutusunu gelen kodu alır, Verification Code text kutusuna girer
        ReusableMethods.switchToWindow(0); // Eski sekmeye geçer
        ReusableMethods.waitFor(10);
        vendorRegisterPage.fakeMailTiklamaZb.click();

        String mailKod = vendorRegisterPage.mailVerivacitonCode.getText();
        String[] sadeceKod = mailKod.split(" ");
        RaporlamaUtil.extentTestInfo("Kullanıcı Verification Code kısmına veri girdiği doğrulanmışır");

        ReusableMethods.switchToWindow(1);
        vendorRegisterPage.verificationCodeClick.sendKeys(sadeceKod[5]);

        //Kullanıcı Register butonuna tıklar
        vendorRegisterPage.vendorRegisterClickZb.click();

        ReusableMethods.waitFor(3);
        System.out.println(vendorRegisterPage.pswEksikMesaji.getText());
        RaporlamaUtil.extentTestInfo("Kullanıcı E-mail ve Verification Code verilerini hatasız girdiğinde bu alanlardan uyarı mesajı almadığı doğrulandı ");

        Assert.assertTrue(vendorRegisterPage.pswEksikMesaji.getText().contains("Password: This field is required."));
        Assert.assertTrue(vendorRegisterPage.pswEksikMesaji.getText().contains("Confirm Password: This field is required."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
