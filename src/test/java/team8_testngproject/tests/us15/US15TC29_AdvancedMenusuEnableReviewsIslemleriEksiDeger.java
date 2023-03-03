package team8_testngproject.tests.us15;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class US15TC29_AdvancedMenusuEnableReviewsIslemleriEksiDeger {// Advanced menusunde Enable reviews ve Menu Order işlemleri Eksi Deger Olmamalı (FAIL)

    private final String testName = "US15 || TC29-Advanced Enable reviews ve Menu Order Quantity işlemleri";
    private final String description = "Vendor Advanced menusunde Enable reviews ve Menu Order Quantity işlemleri yapabilmeli";
    private final String raporMesaji = "Vendor olarak Advanced menusunde Enable reviews ve Menu Order işlemleri gerçekleştirilmiştir..";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void advancedMenusuEnableReviewsIslemleri() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInRs.click();
        loginPage.userNameRs.sendKeys(ConfigReader.getProperty("usernameRs"));
        loginPage.passwordRs.sendKeys(ConfigReader.getProperty("passwordRs"));
        loginPage.signInButtonRs.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        ReusableMethods.jsClick(homePage.myAccountButtonRs);
        ReusableMethods.jsClick(myAccountPage.storeManagerRs);
        ReusableMethods.hover(vendorStoreManagerPage.productButtonRs);
        vendorStoreManagerPage.productAddNewButtonRs.click();

        Select select = new Select(vendorProductManagerPage.productMenuRs);
        select.selectByIndex(0);
        vendorProductManagerPage.productTitleInputRs.sendKeys("SoyleBoyleOyle");
        vendorProductManagerPage.gallerySmallImgRs.click();
        vendorProductManagerPage.mediaLibraryRs.click();
        vendorProductManagerPage.imageOyleRs.click();
        vendorProductManagerPage.addGalleryButtonRs.click();
        vendorProductManagerPage.featuredBigImgRs.click();
        ReusableMethods.jsClick(vendorProductManagerPage.imageOyle2Rs);
        ReusableMethods.jsClick(vendorProductManagerPage.selectButtonForImgRs);
        ReusableMethods.jsClick(vendorProductManagerPage.artsCheckBoxRs);
        ReusableMethods.jsClick(vendorProductManagerPage.advancedMenuRs);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorProductManagerPage.enableReviewsCheckboxRs.isSelected());
        vendorProductManagerPage.advencedMenuOrderTextboxRs.sendKeys("-10");
        Assert.assertTrue(vendorProductManagerPage.advencedMenuOrderTextboxRs.isDisplayed());

        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);
        ReusableMethods.waitFor(2);

        try {
            Assert.assertFalse(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}