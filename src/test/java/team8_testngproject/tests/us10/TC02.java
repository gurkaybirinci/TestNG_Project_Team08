package team8_testngproject.tests.us10;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC02 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;

    @Test
    public void us10_Tc02() {

        //Kullanıcı url'e gider
        //Kullanıcı registor butonuna tıklar
        //Kullanıcı Become a Vendor linkine tıklar
        //Kullanıcı kayıtlı olduğu mail adresini girer
        //Verification Code text kutusuna tıklar
        //Kullanıcı Email kutusunu gelen kodu kopyalar
        //Verification Code text kutusuna yapıştırır
        //Kullanıcı  password kısmına 5 karakterden  büyük ve sadece rakam içeren şifre girer

        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı registor butonuna tıklar
        homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı kayıtlı olduğu mail adresini girer
        //Verification Code text kutusuna tıklar
        //Kullanıcı Email kutusunu gelen kodu kopyalar
        //Verification Code text kutusuna yapıştırır
        vendorRegisterPage=new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));
        vendorRegisterPage.verificationCodeClick.sendKeys(ConfigReader.getProperty("vendor_code"));

        //Kullanıcı  password kısmına 5 karakterden  büyük ve sadece rakam içeren şifre girer
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_weak_psw"));
        Assert.assertEquals(vendorRegisterPage.pswCommentZb.getText(),"Weak");
    }

}
