package team8_testngproject.tests.us03;

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

public class TC01 {

    @Test
    public void testTC01() {

//     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

//    2.  Sing in butonuna tıklanir.
        P01_HomePage homePage = new P01_HomePage();
        homePage.signInButtonsvd.click();

//     3. Username ya da Email inputuna veri girilir.
        P03_LoginPage loginPage = new P03_LoginPage();
        loginPage.usernamesvd.sendKeys(ConfigReader.getProperty("user_name"));

//     4.  Password inputuna veri girilir.
        loginPage.passwordsvd.sendKeys(ConfigReader.getProperty("user_password"));

//     5. Sing in butonuna tiklanir.
        loginPage.signinsvd.click();
        loginPage.singoutsvd.click();

//      6. My Account sayfasına erişildiğini dogrulanir.
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        Assert.assertEquals(myAccountPage.myAccountsvd.getText(), "My Account");

//    7.   Addresses butonuna tiklanir.
        P05_AddressesPage adressPage = new P05_AddressesPage();
        adressPage.addressvd.click();

//    8.  Billing Adress bolumundeki ADD butonuna tiklanir.
        adressPage.addsvd.click();

//    9. 10 .  First name inputuna veri girilir. //Last name inputuna veri girilir.
        adressPage.firstNamesvd.sendKeys("Sevda",
                Keys.TAB, "ISIK");
//    11.  Country/Region dropdown'indan secim yapilir.
        Select select = new Select(adressPage.citysvd);
        select.selectByVisibleText("Turkey");

//     12. Street adress alanina veri girilir.
        adressPage.adreskutususvd.sendKeys("Fuzuli caddesi");
        adressPage.adress2svd.sendKeys("Ela apt");

//     13.  Town/City alanina veri girilir.
        adressPage.city2svd.sendKeys("Kayseri");

//    14.  State dropdown'undan secim yapilir.


//    15.  Postcode / ZIP alanina veri girilir.
        adressPage.kutu2svd.sendKeys("10");

//    16. Phone alanina veri girilir.


//     17. Email adresinin otomatik olarak geldigi dogrulanir.


//     18.Otomatik olarak gelen Email adresinin kayit olunan email adresiyle ayni oldugunu dogrulanir.


//    19. SAVE ADDRESS butonuna tiklanir.


//    20. Kaydedilen adresin Billing Address olarak kayit edildigi dogrulanir


    }

}
