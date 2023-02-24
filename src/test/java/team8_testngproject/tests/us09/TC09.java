package team8_testngproject.tests.us09;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC09 {

    @Test(testName = "US09 || TC09-Vendor Password", description = "Password'ü tekrar yazmalı ")

    public void us09_Tc09() {
        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage=new P14_VendorRegisterPage();
        String fakeMail=vendorRegisterPage.fakeMailKutuZb.getText();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()");

        //Kullanıcı Url gider
        ReusableMethods.switchToWindow(1);
        Driver.getDriver().navigate().to("https://hubcomfy.com/vendor-register/");


        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage=new P02_RegisterPage();
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

        String mailKod=vendorRegisterPage.mailVerivacitonCode.getText();
        String[] sadeceKod=mailKod.split(" ");
        System.out.println("KOD" + sadeceKod[5]);

        ReusableMethods.switchToWindow(1);
        vendorRegisterPage.verificationCodeClick.sendKeys(sadeceKod[5]);

        //Kullanıcı Password kutusuna kucuk harf, büyük harf, rakam ve special karakter girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_strong_psw"));

        //Kullanıcı Confirm Password alanına, eksik password girer
        vendorRegisterPage.confirmPwd.sendKeys(ConfigReader.getProperty("vendor_strong_psw_eksik"));

        //Kullanıcı Register butonuna tıklar (Kullanıcı "Password and Confirm-password are not same."mesajını görmeli)
        vendorRegisterPage.vendorRegisterClickZb.click();
        Assert.assertEquals(vendorRegisterPage.kisaPwdMesaj.getText(),"Password and Confirm-password are not same.");
        Driver.closeDriver();

    }
}
