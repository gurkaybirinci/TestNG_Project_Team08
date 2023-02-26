package team8_testngproject.tests.us15;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
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

public class US15TC16_AttributesMenusundeADDIslemleri {// Attributes menusunde ADD işlemleri (PASS)

    private final String testName = "US15 || TC16-Attributes menusunde ADD işlemleri";
    private final String description = "Vendor Attributes menusunde ADD işlemleri yapabilmeli";
    private final String raporMesaji = "Vendor olarak Attributes menusunde ADD işlemleri yapabildiği doğrulanmıştır.";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void attributesMenuADDIslemleri() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();
        Actions actions =new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInRs.click();
        loginPage.userNameRs.sendKeys(ConfigReader.getProperty("usernameRs"));
        loginPage.passwordRs.sendKeys(ConfigReader.getProperty("passwordRs"));
        loginPage.signInButtonRs.click();
        extentTest.info("Login işlemi yapıldı.");

        //homePage.myAccountButtonRs.click();
        homePage.signOutRs.click();
        myAccountPage.storeManagerRs.click();
        actions.keyDown(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        ReusableMethods.hover(vendorStoreManagerPage.productButtonRs);
        vendorStoreManagerPage.productAddNewButtonRs.click();
        extentTest.info("Add Product sayfasına gidildi.");

        Select select = new Select(vendorProductManagerPage.productMenuRs);
        select.selectByIndex(0);
        vendorProductManagerPage.productTitleInputRs.sendKeys("SoyleBoyleOyle");
        vendorProductManagerPage.gallerySmallImgRs.click();
        vendorProductManagerPage.mediaLibraryRs.click();
        vendorProductManagerPage.imageOyleRs.click();
        vendorProductManagerPage.addGalleryButtonRs.click();
        vendorProductManagerPage.featuredBigImgRs.click();
        vendorProductManagerPage.imageOyle2Rs.click();
        vendorProductManagerPage.selectButtonForImgRs.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.artsCheckBoxRs);
        actions.keyDown(Keys.PAGE_DOWN).perform();
        vendorProductManagerPage.attributesMenuRs.click();
        vendorProductManagerPage.addAttributeADDButonRs.click();
        ReusableMethods.jsClick(vendorProductManagerPage.attributeAddAttributeActiveCheckboxRs);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(vendorProductManagerPage.attributeAddAttributeNameTextboxRs);
        Driver.driver.switchTo().alert().sendKeys("Shapes");
        ReusableMethods.jsClick(vendorProductManagerPage.attributeAddAttributeValueTextboxRs);
        Driver.driver.switchTo().alert().sendKeys("oyle | boyle");
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        vendorProductManagerPage.addAttributeVisibleCheckboxRs.click();
        extentTest.info("Code metin kutusuna veri girilebilirliği ve checkbox seçim yapılabildiği kontrol edildi.");

        ReusableMethods.jsClick(vendorProductManagerPage.submitButtonMangProdRs);
        ReusableMethods.waitFor(2);

        Assert.assertTrue(vendorProductManagerPage.productAddedSuccessRs.isDisplayed());
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}