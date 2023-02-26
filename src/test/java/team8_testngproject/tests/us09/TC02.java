package team8_testngproject.tests.us09;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;


public class TC02 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    private final String testName = "US09 || TC02-e-mail Kutusu ";
    private final String description = "e mail kutusuna veri girilebilmeli";
    private final String raporMesaji = "Kullanıcı sadece e mail bilgilerini girdiğinde hata mesajı almalı";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void us09_Tc02() throws InterruptedException {

        ExtentTest extentTest = RaporlamaUtil.extentTest;
        //Kullanıcı fake url gider
        Driver.getDriver().get(ConfigReader.getProperty("URL_Fake"));
        vendorRegisterPage=new P14_VendorRegisterPage();
        String mailAdresi=vendorRegisterPage.fakeMailKutuZb.getText();
        System.out.println(mailAdresi);

        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı fake url'den almış olduğu valid Email adresini girer
        vendorRegisterPage.emailzb.sendKeys(mailAdresi);
        extentTest.info("Kullanıcı mail kutusuna veri girdiği doğrulanmışır");


        //Register  kutusuna tıklar !!!!! tekrar kontrol et
        vendorRegisterPage.vendorRegisterClickZb.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Email Verification Code: This field is required."));
        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Password: This field is required."));
        Assert.assertTrue(vendorRegisterPage.emailUyariZb.getText().contains("Confirm Password: This field is required."));
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}
