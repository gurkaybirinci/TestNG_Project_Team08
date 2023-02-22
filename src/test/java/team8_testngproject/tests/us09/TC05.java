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

public class TC05 {
    //Kullanıcı fake Url gider
    //Kullanıcı fake mail adresi alır
    //Kullanıcı url'e gider
    //Kullanıcı Register butonuna tıklar
    //Kullanıcı Become a Vendor linkine tıklar
    //Kullanıcı fake Url den aldığı Email bilgilerini girer
    //Verification Code text kutusuna tıklar
    //Kullanıcı Fake Email kutusunu gelen kodu alır, Verification Code text kutusuna girer
    //Kullanıcı Register butonuna tıklar(Password: This field is required.
                                        //Confirm Password: This field is required.)

    @Test
    public void us09_Tc05() {
        //Kullanıcı fake URL gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));

        //Kullanıcı fake mail adresi alır
        P14_VendorRegisterPage vendorRegisterPage=new P14_VendorRegisterPage();
        String fakeMail=vendorRegisterPage.fakeMailKutuZb.getText();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open()"); //Yeni sekme açar

        //Kullanıcı Url gider
        ReusableMethods.switchToWindow(1); // Yeni sekmeye geçer
        Driver.getDriver().navigate().to("https://hubcomfy.com/vendor-register/"); // Yeni sekmede URL'yi açar


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
        ReusableMethods.switchToWindow(0); // Eski sekmeye geçer
        ReusableMethods.waitFor(10);
        vendorRegisterPage.fakeMailTiklamaZb.click();

        String mailKod=vendorRegisterPage.mailVerivacitonCode.getText();
        String[] sadeceKod=mailKod.split(" ");
        System.out.println("KOD" + sadeceKod[5]);


        ReusableMethods.switchToWindow(1);
        vendorRegisterPage.verificationCodeClick.sendKeys(sadeceKod[5]);

        //Kullanıcı Register butonuna tıklar!!!!
        vendorRegisterPage.vendorRegisterClickZb.click();
        Assert.assertEquals(vendorRegisterPage.pswEksikMesaji.getText(),"Password: This field is required." +
                "Confirm Password: This field is required.");






    }

}
