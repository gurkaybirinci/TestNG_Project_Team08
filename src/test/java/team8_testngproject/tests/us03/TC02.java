package team8_testngproject.tests.us03;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P05_AddressesPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC02 {
    private final String testName = "US03 || TC02-Billing Address kaydetme NEGATIVE senaryo" ;
    private final String description = "Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";

    private final String raporMesaji = "Address kaydi tamamlanamadi ve hata mesaji goruntulendi";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)

    public void testTC02() {

        ExtentTest extentTest = RaporlamaUtil.extentTest;
        //     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //    2.  Sing in butonuna tıklanir.
        P01_HomePage homePage = new P01_HomePage();
        homePage.signInButtonsvd.click();
        //     3. Username ya da Email inputuna veri girilir.
        P03_LoginPage loginPage = new P03_LoginPage();
        loginPage.usernamesvd.sendKeys(ConfigReader.getProperty("user_namesvd"));

//     4.  Password inputuna veri girilir.
        loginPage.passwordsvd.sendKeys(ConfigReader.getProperty("user_passwordsvd"));

//     5. Sing in butonuna tiklanir.
        loginPage.signinsvd.click();
        loginPage.singoutsvd.click();
        extentTest.info("Login işlemi yapıldı.");

        //      6. My Account sayfasına erişildiğini dogrulanir.
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

        //    7.   Addresses butonuna tiklanir.
        P05_AddressesPage adressPage = new P05_AddressesPage();
        adressPage.addressvd.click();

//    8.  Billing Adress bolumundeki ADD butonuna tiklanir.
        adressPage.addsvd.click();

//     Doldurulmasi gereken zorunlu inputlarin bos birakilma durumu test edilir.

        adressPage.firstNamesvd.sendKeys("",
                Keys.TAB, "ISIK");
        Select select = new Select(adressPage.citysvd);
        select.selectByVisibleText("Turkey");

        adressPage.adreskutususvd.sendKeys("Fuzuli caddesi");
        adressPage.adress2svd.sendKeys("Ela apt");

        adressPage.city2svd.sendKeys("Kayseri");
        adressPage.kutu2svd.sendKeys("10");
        adressPage.phonesvd.sendKeys("05556545642");
        extentTest.info("Address kaydi tamamlanamadi ve hata mesaji goruntulendi.");

        //SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);

//      Kaydin tamamlanamadigina dair "Province is a required field." hata mesaji goruntulendigi dogrulanir.
        Assert.assertTrue(adressPage.msjsvd.getText().contains("Province is a required field."));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }


}
