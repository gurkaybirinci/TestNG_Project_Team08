package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC07 {

    //Kullanıcı url'e gider
    //Kullanıcı Register butonuna tıklar
    //Kullanıcı Become a Vendor linkine tıklar
    //Kullanıcı Email bilgileri girer
    //Verification Code girer
    //Kullanıcı Password kutusuna kucuk harf, büyük harf, rakam ve special karakter girer
    //Kullanıcı Confirm Password alanına, Password kutusuna girmiş olduğu bilgileri girer
    //Kullanıcı Register butonuna tıklar

    @Test
    public void us09_Tc07() {

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
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));

        //Kullanıcı Confirm Password alanına, Password kutusuna girmiş olduğu bilgileri girer
        vendorRegisterPage.confirmPwd.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));

        //Kullanıcı Register butonuna tıklar (Kullanıcı "Password strength should be atleast "Good". mesajını görmeli)
        vendorRegisterPage.vendorRegisterClickZb.click();
        ReusableMethods.waitFor(5);
        vendorRegisterPage.vendorRegisterClickZb.click();

        //doğrulama sıkıntısııııı
        Assert.assertEquals(vendorRegisterPage.kisaPwdMesaj.getText(),"Password strength should be atleast \"Good\".");








    }
}
