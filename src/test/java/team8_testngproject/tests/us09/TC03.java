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

    @Test
    public void us09_Tc03() {

        //Kullanıcı fake Url gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));
        vendorRegisterPage=new P14_VendorRegisterPage();
        String fakeMail=vendorRegisterPage.fakeMailKutuZb.getText();
        String yeniMail=fakeMail.replace(".com"," ");
        System.out.println(yeniMail);


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


        //Kullanıcı verificationCode kutusuna tıklar          !!!kontrol
        vendorRegisterPage.verificationCodeClick.click();
        Assert.assertTrue(vendorRegisterPage.verivacitonInvalidMesajZb.getText().contains("Please provide a valid email address."));
        ReusableMethods.waitFor(3);

        //Assert.assertEquals(vendorRegisterPage.eksikMailHataMesajiZb.getText(),"Please provide a valid email address.");



    }



}
