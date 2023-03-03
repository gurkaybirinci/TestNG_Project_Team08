package team8_testngproject.tests.us14;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC02_Urun_Fotografi_Ekleme { // Ürün fotoğrafı (büyük olan-Featured Img) eklenebilmeli (PASS)
    private final String testName = "US14 || TC02-Ürün Fotoğrafı Ekleme";
    private final String description = "Ürün fotoğrafı (büyük olan-Featured Img) eklenebilmeli";
    private final String raporMesaji = "Ürün fotoğrafı (büyük olan-Featured Img) eklenebildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInGur.click();
        loginPage.userNameGur.sendKeys(ConfigReader.getProperty("usernameGur"));
        loginPage.passwordGur.sendKeys(ConfigReader.getProperty("passwordGur"));
        loginPage.signInButtonGur.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();
        RaporlamaUtil.extentTestInfo("Product Manager sayfasına girildi.");

        vendorProductManagerPage.featuredImgGur.click();
        vendorProductManagerPage.mediaLibraryGur.click();
        vendorProductManagerPage.image1Gur.click();
        vendorProductManagerPage.selectButtonGur.click();
        RaporlamaUtil.extentTestInfo("Ürün fotoğrafı (büyük olan-Featured Img) eklenip eklenemediği kontrol edilmiştir.");

        Assert.assertTrue(vendorProductManagerPage.removeImgBigGur.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}