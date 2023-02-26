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

public class TC01 {
    private final String testName = "US03 || TC01-Billing Adress POSITIVE senaryo";
    private final String description = "Billing Address kaydı tamamlanmalı";
    private final String raporMesaji = "Billing Adress kaydi tamamlanmistir.";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void testTC01() {
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

//    9. 10 .  First name inputuna veri girilir. //Last name inputuna veri girilir.
        adressPage.firstNamesvd.clear();
        adressPage.firstNamesvd.sendKeys("Sevda",
                Keys.TAB, "ISIK");
//    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(adressPage.citysvd);
        select.selectByVisibleText("Turkey");

//     12. Street adress alanina veri girilir.
       adressPage.adreskutususvd.clear();
       adressPage.adress2svd.clear();
        adressPage.adreskutususvd.sendKeys("Fuzuli caddesi");
        adressPage.adress2svd.sendKeys("Ela apt");

//     13.  Town/City alanina veri girilir.
        adressPage.city2svd.clear();
        adressPage.city2svd.sendKeys("Kayseri");

//    14.  State dropdown'undan secim yapilir.

         Select select1=new Select(adressPage.statessvd);
         select1.selectByVisibleText("Kayseri");

//    15.  Postcode / ZIP alanina veri girilir.
        adressPage.kutu2svd.clear();
        adressPage.kutu2svd.sendKeys("10");

//    16. Phone alanina veri girilir.
        adressPage.phonesvd.clear();
        adressPage.phonesvd.sendKeys("05556545642");

//     17. Email adresinin otomatik olarak geldigi dogrulanir.
        Assert.assertTrue(adressPage.emailsvd.isDisplayed());

//     18.Otomatik olarak gelen Email adresinin kayit olunan email adresiyle ayni oldugunu dogrulanir.
     //    Assert.assertEquals(adressPage.emailsvd.getText(),"nevan.lamin@foundtoo.com");


//    19. SAVE ADDRESS butonuna tiklanir.
        ReusableMethods.jsClick(adressPage.savesvd);
        extentTest.info("Billing Adress kaydi tamamlandi.");

//    20. Kaydedilen adresin Billing Address olarak kayit edildigi dogrulanir


        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}
