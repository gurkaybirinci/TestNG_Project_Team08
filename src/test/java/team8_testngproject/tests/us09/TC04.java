package team8_testngproject.tests.us09;

import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC04 {
    //Kullanıcı url'e gider
    //Kullanıcı Register butonuna tıklar
    //Kullanıcı Become a Vendor linkine tıklar
    //Kullanıcı valid Email bilgileri girer
    //Verification Code text kutsuna tıklar( "Verification code sent to your email: abc@abc.com." mesajını görmeli)


    @Test
    public void us09_Tc04() {
        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage=new P14_VendorRegisterPage();
        String fakeMail=vendorRegisterPage.fakeMailKutuZb.getText();


        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        P01_HomePage homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        P02_RegisterPage registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı valid Email bilgileri girer
        vendorRegisterPage.emailzb.sendKeys(fakeMail);

        //Verification Code text kutsuna tıklar
         vendorRegisterPage.verificationCodeClick.click();


         //==>bunu kontrol et??*??**?
        //element.getAttribute("validationMessage"); bunu deneeeee


         vendorRegisterPage.verificationCodeClick.isDisplayed();



    }
}
