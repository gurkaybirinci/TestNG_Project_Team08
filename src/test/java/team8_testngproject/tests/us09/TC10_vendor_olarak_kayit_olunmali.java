package team8_testngproject.tests.us09;

import com.aventstack.extentreports.ExtentTest;
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

public class TC10_vendor_olarak_kayit_olunmali {
    private final String testName = "US09 || TC10- vendor olarak kayıt olunmalı";
    private final String description = "Tüm kutular eksiksiz doldurulmalı";
    private final String raporMesaji = "Register butonuna tıklandığında Successfully mesajı aldığı doğrulanmıştır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us09_Tc10() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage = new P14_VendorRegisterPage();
        String fakeMail = vendorRegisterPage.fakeMailKutuZb.getText();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");

        //Kullanıcı Url gider
        ReusableMethods.switchToWindow(1);
        Driver.getDriver().navigate().to("https://hubcomfy.com/vendor-register/");

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı fake Url den aldığı  Email bilgileri girer
        vendorRegisterPage.emailzb.sendKeys(fakeMail);

        //Verification Code text kutusuna tıklar
        vendorRegisterPage.verificationCodeClick.click();
        ReusableMethods.waitFor(5);

        //Kullanıcı Fake Email kutusunu gelen kodu alır, Verification Code text kutusuna girer
        ReusableMethods.switchToWindow(0);
        ReusableMethods.waitFor(10);
        vendorRegisterPage.fakeMailTiklamaZb.click();

        String mailKod = vendorRegisterPage.mailVerivacitonCode.getText();
        String[] sadeceKod = mailKod.split(" ");
        System.out.println("KOD" + sadeceKod[5]);
        ReusableMethods.waitFor(2);

        ReusableMethods.switchToWindow(1);
        vendorRegisterPage.verificationCodeClick.sendKeys(sadeceKod[5]);
        //Kullanıcı strong Password girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_strong_psw"));

        //Kullanıcı Password kutusuna girmiş olduğu password'u Confirm Password kutusuna tekrar girer
        vendorRegisterPage.confirmPwd.sendKeys(ConfigReader.getProperty("vendor_strong_psw"));

        //Kullanıcı Register butonuna tıklar
        vendorRegisterPage.vendorRegisterClickZb.click();
        ReusableMethods.waitFor(3);
        RaporlamaUtil.extentTestInfo("Kullanıcı tüm alanları eksiksiz ve doğru doldurduğunda Register olma durumu kontrol edildi ");
        Assert.assertEquals(vendorRegisterPage.succesMesajZb.getText(), "Welcome to Hubcomfy!");
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
