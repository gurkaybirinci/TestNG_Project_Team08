package team8_testngproject.tests.us14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC31 { // External/Affiliate Product seçeneği içindeki URL kutusuna URL formatı dışında veri girilememeli (FAIL)
    @Test
    public void tc01(){
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

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();

        Select select = new Select(vendorProductManagerPage.productMenuGur);
        select.selectByIndex(3);
        vendorProductManagerPage.productTitleGur.sendKeys("Steteskop");
        vendorProductManagerPage.urlBoxGur.sendKeys("Çok güzel bir steteskop...");
        vendorProductManagerPage.galleryImgGur.click();
        vendorProductManagerPage.mediaLibraryGur.click();
        vendorProductManagerPage.image1Gur.click();
        vendorProductManagerPage.addGalleryButtonGur.click();
        vendorProductManagerPage.featuredImgGur.click();
        vendorProductManagerPage.image2Gur.click();
        vendorProductManagerPage.selectButtonGur.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.categoryAccessoriesGur);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.submitButtonGur);
        ReusableMethods.waitFor(1);

        try {
            Assert.assertFalse(vendorProductManagerPage.productAddedSuccessGur.isDisplayed());
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e;
        } finally {
            Driver.closeDriver();
        }
    }
}