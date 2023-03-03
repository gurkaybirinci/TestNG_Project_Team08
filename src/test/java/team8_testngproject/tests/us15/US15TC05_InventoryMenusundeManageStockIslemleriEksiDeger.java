package team8_testngproject.tests.us15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class US15TC05_InventoryMenusundeManageStockIslemleriEksiDeger { // Inventory menusunde Manage Stock işlemleri EKsi Değer (FAIL)

    private final String testName = "US15 || TC05-Inventory menusunde Manage Stock işlemleri";
    private final String description = "Vendor Inventory menusunde Manage Stock işlemleri Eksi Değer Amamali";
    private final String raporMesaji = "Inventory menusunde Manage Stock işlemleri eksi değer almaması gerektiği doğrulanamamıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void inventoryMenuManageStockIslemleriEksiDeger() {
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
        ReusableMethods.jsClick(vendorProductManagerPage.inventoryMenuRs);
        ReusableMethods.jsClick(vendorProductManagerPage.manageStockCheckboxRs);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).release().perform();
        ReusableMethods.waitFor(2);
        vendorProductManagerPage.stockQtyTextboxRs.clear();
        vendorProductManagerPage.stockQtyTextboxRs.sendKeys("-50");
        Assert.assertTrue(vendorProductManagerPage.stockQtyTextboxRs.isDisplayed());
        ReusableMethods.waitFor(2);
        RaporlamaUtil.extentTestInfo("Code metin kutusuna veri girilebilirliği kontrol edildi.");

        select = new Select(vendorProductManagerPage.allowBackordersDropdownRs);
        select.selectByIndex(1);
        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);
        ReusableMethods.waitFor(0);

        try {
            Assert.assertFalse(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        } catch (AssertionError e) {
            throw e;
        } finally {
            RaporlamaUtil.message = "<span style='color:red; font-weight:bold; font-size: 16px'>BUG BULUNDU: &#x1F41E</span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
        }
    }
}



