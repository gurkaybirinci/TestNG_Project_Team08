package team8_testngproject.tests.us13;

import org.openqa.selenium.JavascriptExecutor;
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

public class TC03 {
    private final String testName = "US13 || TC03-Shipping Adress 'first name' alanı alfabetik karakter dışında değer kabul etmemeli";
    private final String description = "Vendor Shipping Address kaydi tamamlanamamali ve hata mesaji goruntulenmeli";
    private final String raporMesaji = "Vendor Shipping Address kaydi tamamlandı ve hata mesaji goruntulenmedi";


    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc03() {
        //     1. Belirtilen URL'e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //     2. Sing in butonuna tıklanir.
        P01_HomePage homePage = new P01_HomePage();
        homePage.signInButtonAli.click();

        //     3. Username ya da Email inputuna veri girilir.
        P03_LoginPage loginPage = new P03_LoginPage();
        loginPage.usernameAli.sendKeys(ConfigReader.getProperty("vendorUserNameAli"));

        //     4.  Password inputuna veri girilir.
        loginPage.passwordAli.sendKeys(ConfigReader.getProperty("vendorPasswordAli"));

        //      5. signOut butonuna tıklar
        loginPage.loginAli.click();
        RaporlamaUtil.extentTestInfo("Login islemi yapıldı");
        //      6. signOut butonuna tıklar
        homePage.signOutButtonAli.click();

        //      7. My Account sayfasına erişildiğini dogrulanir.
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        Assert.assertEquals(myAccountPage.myAccountPageAli.getText(), "My Account");
        RaporlamaUtil.extentTestInfo("MyAccount sayfasında oldugu dogrulandı.");

        //     8. Address butonuna tıklar.
        myAccountPage.AddressesLinkAli.click();

        //     9. Shipping (sipariş) addressi add (edit your billing) butonuna tıklar
        P05_AddressesPage addressesPageAli = new P05_AddressesPage();
        ReusableMethods.jsClick(addressesPageAli.shippingaddButtonAli);

        //     10.  "first name" alanına alfabetik karakter dışında değer girilmemeli/FAİL
        addressesPageAli.shippingfirstNameAli.clear();
        String data = "123 / /*?";
        addressesPageAli.shippingfirstNameAli.sendKeys(data);
        String actualText = ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].value;", addressesPageAli.shippingfirstNameAli).toString();

        RaporlamaUtil.extentTestInfo("First name alanına alfabetik karakter dışında deger girildiğinde bu alanda bir uyarı mesajı çıkıp çıkmadığı kontrol edilmiştir.");
        try{
            Assert.assertFalse(actualText.contains(data));
        }catch (AssertionError e){
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }

    }

