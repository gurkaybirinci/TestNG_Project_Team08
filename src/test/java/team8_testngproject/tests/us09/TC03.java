package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC03 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;

    @Test(testName = "US09 || TC03-Vendor Kayıt", description = "e-mail adresine invalid değer girmeli ")
    public void us09_Tc03() {

        //Kullanıcı fake Url gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));
        vendorRegisterPage=new P14_VendorRegisterPage();
        String fakeMail=vendorRegisterPage.fakeMailKutuZb.getText();
        String yeniMail=fakeMail.replace(".com"," ");

        //Kullanıcı URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı fake email'i eksik girer
        vendorRegisterPage=new P14_VendorRegisterPage();
        vendorRegisterPage.emailzb.sendKeys(yeniMail);

        //Kullanıcı verificationCode kutusuna tıklar (Please provide a valid email address.)
        vendorRegisterPage.verificationCodeClick.click();
        ReusableMethods.waitFor(3);
        System.out.println(vendorRegisterPage.eksikMailHataMesajiZb.getText());
        Assert.assertTrue(vendorRegisterPage.eksikMailHataMesajiZb.getText().contains("Please provide a valid email address."));
        Driver.closeDriver();
    }
}
