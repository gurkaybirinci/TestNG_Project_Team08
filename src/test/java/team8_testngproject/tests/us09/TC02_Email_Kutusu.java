package team8_testngproject.tests.us09;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;


public class TC02_Email_Kutusu {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US09 || TC02-E-mail Kutusu ";
    private final String description = "e-mail adresi girmeli ";
    private final String raporMesaji = "Kullanıcı sadece e-mail bilgilerini girdiğinde e-mail ile ilgili hata mesajı almadığı doğrulandı";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void us09_Tc02() throws InterruptedException {
        //Kullanıcı fake url gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));
        vendorRegisterPage = new P14_VendorRegisterPage();
        String mailAdresi = vendorRegisterPage.fakeMailKutuZb.getText();
        RaporlamaUtil.extentTestInfo("Kullanıcının fake mail adresi alabilirliği kontrol edildi");
        System.out.println(mailAdresi);

        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage = new P02_RegisterPage();
        registerPage.becomeVendorZb.click();
        RaporlamaUtil.extentTestInfo("Become a Vendor linki ile giriş yapabildi.");

        //Kullanıcı fake url'den almış olduğu valid Email adresini girer
        vendorRegisterPage.emailzb.sendKeys(mailAdresi);
        RaporlamaUtil.extentTestInfo("Kullanıcının mail kutusuna veri girdiği doğrulanmışır");

        //Register  kutusuna tıklar
        vendorRegisterPage.vendorRegisterClickZb.click();
        ReusableMethods.waitFor(1);
        RaporlamaUtil.extentTestInfo("Kullanıcı e-mail dışında diğer boş alanlardan hata mesajı alma durumu kontrol edildi");

        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Email Verification Code: This field is required."));
        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Password: This field is required."));
        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Confirm Password: This field is required."));
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}
