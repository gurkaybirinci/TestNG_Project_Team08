package team8_testngproject.tests.us14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.util.List;

public class TC04_Urun_Fotografi_Ekleme { // Ürüne ait bir tane küçük (Gallery Images) resim eklendiğinde, bu resimden ürün sayfasında bir tane olmalı (FAIL)
    private final String testName = "US14 || TC04-Ürün Fotoğrafı Ekleme";
    private final String description = "Ürüne ait bir tane küçük (Gallery Images) resim eklendiğinde, bu resimden ürün sayfasında bir tane olmalı";
    private final String raporMesaji = "Ürüne ait Featured image ve Gallery image eklendiğinde, ürün sayfasında gallery image'a ait resim iki kez gösteriliyor. " +
            "Gallery image bölümüne Featured image'dan farklı bir resim eklenince sorun olmuyor, " +
            "ama sadece bir resim eklemek isteyen birisinin ürün sayfası düzgün görüntülenmemiş oluyor";

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

        vendorProductManagerPage.productTitleGur.sendKeys("Steteskop");
        vendorProductManagerPage.galleryImgGur.click();
        vendorProductManagerPage.mediaLibraryGur.click();
        vendorProductManagerPage.image1Gur.click();
        vendorProductManagerPage.addGalleryButtonGur.click();
        vendorProductManagerPage.featuredImgGur.click();
        vendorProductManagerPage.image2Gur.click();
        vendorProductManagerPage.selectButtonGur.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.categoryAccessoriesGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.submitButtonGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.viewButtonGur);

        ReusableMethods.switchToWindow(1);
        List<WebElement> imgElements = vendorProductManagerPage.galleryImgDivGur.findElements(By.tagName("img"));
        RaporlamaUtil.extentTestInfo("Ürüne ait bir tane küçük (Gallery Images) resim eklendiğinde, bu resimden ürün sayfasında bir tane olup olmadığı kontrol edilmiştir.");

        try {
            Assert.assertEquals(imgElements.size(), 1);
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}
