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

public class US15TC06_InventoryMenusundeStockStatusIslemleri { // Inventory menusunde Stock Status Işlemleri (PASS)

    private final String testName = "US15 || TC06-Inventory menusunde Stock Status işlemleri";
    private final String description = "Vendor Inventory menusunde Stock Status işlemleri yapabilmeli";
    private final String raporMesaji = "Vendor olarak Stock Status işlemleri yapabildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void inventoryMenuStockStatusIslemleri() {
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
        ReusableMethods.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).release().perform();
        Select select1 = new Select(vendorProductManagerPage.stockStatusDropdownRs);
        select1.selectByIndex(0);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorProductManagerPage.stockStatusDropdownRs.isDisplayed());
        select1.selectByIndex(1);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorProductManagerPage.stockStatusDropdownRs.isDisplayed());
        select1.selectByIndex(2);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(vendorProductManagerPage.stockStatusDropdownRs.isDisplayed());
        RaporlamaUtil.extentTestInfo("Dropdown menu kontrol edildi.");

        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);
        ReusableMethods.waitFor(0);

        Assert.assertTrue(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}

