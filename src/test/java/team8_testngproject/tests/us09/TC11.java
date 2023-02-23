package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC11 {
    @Test(testName = "US09 || TC11-Vendor Register", description = "Kayıtlı bir e-mail adresi ile kayıt olmaya çalıştığında This Email already exists." +
                     "Please login to the site and apply as vendor. mesajını almalı")

    public void us09_11() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı Email bilgileri girer
        P14_VendorRegisterPage vendorRegisterPage=new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));

        //Verification Code girer
        vendorRegisterPage.verificationCodeClick.sendKeys(ConfigReader.getProperty("vendor_code"));

        //Kullanıcı Password kutusuna kucuk harf, büyük harf, rakam ve special karakter girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_strong_psw"));

        //Kullanıcı Confirm Password alanına, Password kutusuna girmiş olduğu bilgileri girer
        vendorRegisterPage.confirmPwd.sendKeys(ConfigReader.getProperty("vendor_strong_psw"));

        //Kullanıcı Register butonuna tıklar (This Email already exists. Please login to the site and apply as vendor.)
        vendorRegisterPage.vendorRegisterClickZb.click();
        Assert.assertEquals(vendorRegisterPage.kisaPwdMesaj.getText(),"This Email already exists. Please login to the site and apply as vendor.");
        Driver.closeDriver();
    }
}
