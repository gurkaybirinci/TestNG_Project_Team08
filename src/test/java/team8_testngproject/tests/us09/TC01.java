package team8_testngproject.tests.us09;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;


public class TC01 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    @Test(testName = "US09 || TC01-Become a Vendor", description = "Sign Up ekranından Become a Vendor linki ile giriş yapılabilmeli ")

    public void us09_Tc01() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı Register butonuna tıklar
        homePage = new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Vendor Registration sayfasının erişildiğini dogrular
         vendorRegisterPage = new P14_VendorRegisterPage();
        Assert.assertEquals(vendorRegisterPage.vendorDogrulaZb.getText(), "Vendor Registration");
        Driver.closeDriver();
    }
}


        







