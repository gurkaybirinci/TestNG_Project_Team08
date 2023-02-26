package team8_testngproject.tests.us10;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

public class TC01 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US10 || TC01-Password Metin Kutusu";
    private final String description = "Password Metin Kutusuna veri girildiğinde uyarı mesajı almalı";
    private final String raporMesaji = "Password Metin Kutusuna metin girildiğinde too short yazısının görünürlüğü doğrulandı";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void us10_Tc01() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;

        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı registor butonuna tıklar
        homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı kayıtlı olduğu mail adresini girer
         vendorRegisterPage=new P14_VendorRegisterPage();
         vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));

        //Kullanıcı password kısmına 6 karakterden küçük değer girer
        vendorRegisterPage.vendorPassowordZb.click();
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));
        Assert.assertEquals(vendorRegisterPage.pswCommentZb.getText(),"Too short");
        extentTest.info("Kullanıcı password kısmına  veri girdiği doğrulanmışır");

        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
