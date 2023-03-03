package team8_testngproject.tests.us19;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC05 {
    private final String testName = "US19 || TC05-Ödeme Seçenekleri";
    private final String description = "Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli";
    private final String raporMesaji = "Wire transfer/EFT veya Pay at the door seçeneklerinin seçilebildiği doğrulandı";
    P01_HomePage p01HomePage;
    P03_LoginPage p03LoginPage;
    P04_MyAccountPage p04MyAccountPage;
    P19_OrdersPage p19OrdersPage;
    P07_ShoppingPage p07ShoppingPage;
    P08_ProductPage p08ProductPage;
    P10_CheckOutPage p10CheckOutPage;
    P15_VendorAddressesPage p15VendorAddressesPage;

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void us19_tc05() {
        p01HomePage = new P01_HomePage();
        p03LoginPage = new P03_LoginPage();
        p04MyAccountPage = new P04_MyAccountPage();
        p19OrdersPage = new P19_OrdersPage();
        p07ShoppingPage = new P07_ShoppingPage();
        p08ProductPage = new P08_ProductPage();
        p10CheckOutPage = new P10_CheckOutPage();
        p15VendorAddressesPage = new P15_VendorAddressesPage();

        //Url'ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Sign In butonuna tıklanır
        p01HomePage.registerButton_Nt.click();

        //Vendor hesapla login işlemi yapılır
        p03LoginPage.emailBox_Nt.sendKeys(ConfigReader.getProperty("vendorMail_Nt"));
        p03LoginPage.passwordBox_Nt.sendKeys(ConfigReader.getProperty("vendorPassword_Nt"));
        p03LoginPage.signInButton_Nt.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı");

        //Sign Out butonuna tıklanır
        p01HomePage.signOutButton_Nt.click();

        //My Account sayfasının görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p04MyAccountPage.myAccountPage_Nt);

        //Orders linkine tıklanır
        p04MyAccountPage.ordersLink_Nt.click();

        //Orders sayfasınanın görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p19OrdersPage.ordersDisplayed_Nt);

        //Browse Products linkine tıklanır
        try {
            ReusableMethods.jsClick(p04MyAccountPage.goShopLink_Nt);
        } catch (Exception e) {
            p19OrdersPage.browseProductsLink_Nt.click();
        }
        RaporlamaUtil.extentTestInfo("Shopping sayfasına gidildi");

        //Shop sayfasının görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p07ShoppingPage.shoppingPageDisplayed_Nt);

        //Search kutusuna değer girilir
        //Arama butonuna tıklanır
        p07ShoppingPage.shoppingSearchBox_Nt.sendKeys(ConfigReader.getProperty("urunIsmi_Nt"), Keys.ENTER);

        //QA bilgisayar ürününe tıklanır
        p07ShoppingPage.urunSecimi01_Nt.click();

        //Add to cart butonuna tıklanır
        p08ProductPage.addToCartButton_Nt.click();

        //Cart butonuna tıklanır
        p08ProductPage.cartButton_Nt.click();

        //Checkout butonuna tıklanır
        p08ProductPage.checkoutButton_Nt.click();

        //Your order yazısının görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p10CheckOutPage.yourOrderDisplayed_Nt);

        //Wire transfer/EFT butonu tıklanır
        Assert.assertTrue(p10CheckOutPage.radioButton1_Nt.isSelected());

        //Pay at the door butonu tıklanır
        ReusableMethods.jsClick(p10CheckOutPage.radioButton2_Nt);
        RaporlamaUtil.extentTestInfo("Vendor olarak Wire transfer/EFT veya Pay at the door seçeneklerinin seçilebilir olması kontrol edildi");

        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";


    }
}
